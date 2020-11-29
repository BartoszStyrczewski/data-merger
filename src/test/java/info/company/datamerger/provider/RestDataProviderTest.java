package info.company.datamerger.provider;

import io.vavr.control.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RestDataProviderTest {

  @Test
  public void testRestInt() {
    Option<Integer> response = new RestDataProvider<>(RestEndpoints.INT, Parsers.INT_PARSER).get();
    Assertions.assertTrue(response.isDefined());
  }

  @Test
  public void testRestString() {
    Option<String> response = new RestDataProvider<>(RestEndpoints.STRING, Parsers.STRING_PARSER).get();
    Assertions.assertTrue(response.isDefined());
  }
}
