package info.company.datamerger;

import info.company.datamerger.provider.DataProvider;
import info.company.datamerger.provider.RestDataProvider;
import io.vavr.control.Option;
import lombok.extern.java.Log;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static info.company.datamerger.ExchangeRates.getExchangeRate;
import static info.company.datamerger.IntegerMerger.sum;
import static org.joda.money.CurrencyUnit.USD;

@Log
public class App {

  public static void main(String[] args) {

    // int random provider + one online constant
    List<DataProvider<Integer>> integerProviders = new ArrayList<>();
    integerProviders.add(DataProvider.randomInt());
    integerProviders.add(RestDataProvider.intDataProvider());
    integerProviders.add(() -> Option.of(17));

    // reducing ints with sum
    Optional<Integer> integer =
        integerProviders.stream()
            .map(DataProvider::get)
            .filter(Option::isDefined)
            .map(
                v -> {
                  Integer i = v.get();
                  log.info("i: " + i);
                  return i;
                })
            .reduce(sum());
    //            .reduce(IntegerMerger.multiply());

    System.out.println("sum result: " + (integer.orElse(0)));

    // string providers
    List<DataProvider<String>> stringProviders = new ArrayList<>();
    stringProviders.add(DataProvider.randomString());
    stringProviders.add(RestDataProvider.stringDataProvider());

    // reducing with custom fun
    Optional<String> string =
        stringProviders.stream()
            .map(DataProvider::get)
            .filter(Option::isDefined)
            .map(
                v -> {
                  String s = v.get();
                  log.info("s: " + s);
                  return s;
                })
            .reduce((s1, s2) -> s1 + " <!> " + s2);

    System.out.println("concat result: " + (string.orElse("")));

    // money providers
    List<DataProvider<Money>> moneyProviders = new ArrayList<>();
    moneyProviders.add(() -> Option.of(Money.of(CurrencyUnit.EUR, 10)));
    moneyProviders.add(() -> Option.of(Money.of(USD, 15)));

    Optional<Money> money =
        moneyProviders.stream()
            .map(DataProvider::get)
            .filter(Option::isDefined)
            .map(
                v -> {
                  Money m = v.get();
                  log.info("m: " + m);
                  return m;
                })
            .reduce(
                (m1, m2) ->
                    m1.convertedTo(
                            USD, getExchangeRate(m1.getCurrencyUnit(), USD), RoundingMode.HALF_UP)
                        .plus(
                            m2.convertedTo(
                                USD, getExchangeRate(m2.getCurrencyUnit(), USD), RoundingMode.HALF_UP)));

    System.out.println("money result: " + (money.orElseGet(() -> Money.zero(USD))));
  }
}
