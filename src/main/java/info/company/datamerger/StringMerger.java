package info.company.datamerger;

public interface StringMerger extends Merger<String>{

  static Merger<String> comma() {
    return (s1, s2) -> String.join(",", s1, s2);
  }

  static Merger<String> newLine() {
    return (s1, s2) -> String.join("\n", s1, s2);
  }
}
