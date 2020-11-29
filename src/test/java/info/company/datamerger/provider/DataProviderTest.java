package info.company.datamerger.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataProviderTest {

  @Test
  public void testIntNotNull() {
    Assertions.assertNotNull(DataProvider.randomInt().get());
  }

  @Test
  public void testStringNotNull() {
    Assertions.assertNotNull(DataProvider.randomString().get());
  }
}
