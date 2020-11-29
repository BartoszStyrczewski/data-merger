package info.company.datamerger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerMergerTest {

  @Test
  public void testPlus() {
    Assertions.assertEquals(4, IntegerMerger.plus().apply(2, 2));
    Assertions.assertEquals(-3, IntegerMerger.plus().apply(-3, 0));
    Assertions.assertEquals(0, IntegerMerger.plus().apply(0, 0));
  }

  @Test
  public void testMultiply() {
    Assertions.assertEquals(4, IntegerMerger.multiply().apply(2, 2));
    Assertions.assertEquals(0, IntegerMerger.multiply().apply(0, -3));
    Assertions.assertEquals(5, IntegerMerger.multiply().apply(5, 1));
  }
}
