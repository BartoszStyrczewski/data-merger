package info.company.datamerger.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static info.company.datamerger.provider.HttpBodyParser.intParser;
import static info.company.datamerger.provider.HttpBodyParser.stringParser;

class ParsersTest {

  @Test
  public void testIntParser() {
    Assertions.assertEquals(Integer.valueOf(1), intParser().apply("1"));
  }

  @Test
  public void testStringParser() {
    Assertions.assertEquals("abc", stringParser().apply(" \n abc \t "));
  }
}
