package info.company.datamerger;

import io.vavr.Tuple2;
import org.joda.money.CurrencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;

import static org.joda.money.CurrencyUnit.EUR;
import static org.joda.money.CurrencyUnit.USD;

public final class ExchangeRates {

  private static final MathContext MATH_CONTEXT = new MathContext(2, RoundingMode.HALF_UP);

  //   supporting USD nad EUR
  private static final Map<Tuple2<CurrencyUnit, CurrencyUnit>, BigDecimal> exchangeRates =
      Map.of(
          new Tuple2<>(USD, EUR),
          new BigDecimal(0.84, MATH_CONTEXT),
          new Tuple2<>(EUR, USD),
          new BigDecimal(1.20, MATH_CONTEXT));

  public static BigDecimal getExchangeRate(CurrencyUnit c1, CurrencyUnit c2) {
    if (c1.equals(c2)) {
      return new BigDecimal(1, MATH_CONTEXT);
    }

    return exchangeRates.get(new Tuple2<>(c1, c2));
  }
}
