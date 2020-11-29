package info.company.datamerger.provider;

import java.util.function.Function;

public interface HttpBodyParser<T> extends Function<String, T> {

  static HttpBodyParser<Integer> intParser() {
    return (String s) -> Integer.valueOf(s.strip());
  }

  static HttpBodyParser<String> stringParser() {
    return String::strip;
  }
}