package info.company.datamerger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringMergerTest {

  @Test
  public void testComma() {
      Assertions.assertEquals("a,b", StringMerger.comma().apply("a", "b"));
  }

  @Test
  public void testNewLine() {
      Assertions.assertEquals("a\nb", StringMerger.newLine().apply("a", "b"));
  }
}
