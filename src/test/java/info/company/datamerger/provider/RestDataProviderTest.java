package info.company.datamerger.provider;

import io.vavr.control.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static info.company.datamerger.provider.HttpBodyParser.intParser;
import static info.company.datamerger.provider.HttpBodyParser.stringParser;
import static info.company.datamerger.provider.RestEndpoints.INT;
import static info.company.datamerger.provider.RestEndpoints.STRING;

class RestDataProviderTest {

  @Test
  public void testRestInt() {
    Option<Integer> response = new RestDataProvider<>(INT, intParser()).get();
    Assertions.assertTrue(response.isDefined());
  }

  @Test
  public void testRestString() {
    Option<String> response = new RestDataProvider<>(STRING, stringParser()).get();
    Assertions.assertTrue(response.isDefined());
  }
}
