package info.company.datamerger;

public interface IntegerMerger extends Merger<Integer> {

  static Merger<Integer> plus() {
    return Integer::sum;
  }

  static Merger<Integer> multiply() {
    return (i1, i2) -> i1 * i2;
  }
}
