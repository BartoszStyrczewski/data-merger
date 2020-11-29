package info.company.datamerger.provider;

import io.vavr.control.Option;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public interface DataProvider<D> {

  static DataProvider<Integer> randomInt() {
    return () -> Option.of(new Random().nextInt(10));
  }

  static DataProvider<String> randomString() {
    return () -> Option.of(RandomStringUtils.random(5, true, false));
  }

  Option<D> get();
}
