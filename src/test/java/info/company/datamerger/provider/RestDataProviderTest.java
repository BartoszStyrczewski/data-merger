package info.company.datamerger.provider;

import io.vavr.control.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static info.company.datamerger.provider.RestDataProvider.intDataProvider;
import static info.company.datamerger.provider.RestDataProvider.stringDataProvider;

class RestDataProviderTest {

  @Test
  public void testRestInt() {
    Option<Integer> response = intDataProvider().get();
    Assertions.assertTrue(response.isDefined());
  }

  @Test
  public void testRestString() {
    Option<String> response = stringDataProvider().get();
    Assertions.assertTrue(response.isDefined());
  }
}
