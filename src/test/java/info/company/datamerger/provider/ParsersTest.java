package info.company.datamerger.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParsersTest {

  @Test
  public void testIntParser() {
    Assertions.assertEquals(Integer.valueOf(1), Parsers.INT_PARSER.apply("1"));
  }

  @Test
  public void testStringParser() {
    Assertions.assertEquals("abc", Parsers.STRING_PARSER.apply(" \n abc \t "));
  }
}
