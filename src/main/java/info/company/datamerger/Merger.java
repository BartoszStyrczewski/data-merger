package info.company.datamerger;

import java.util.function.BiFunction;

public interface Merger<T> extends BiFunction<T, T, T> {}
