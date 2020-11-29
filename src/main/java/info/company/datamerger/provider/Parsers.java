package info.company.datamerger.provider;

import java.util.function.Function;

public final class Parsers {
    public static final Function<String, Integer> INT_PARSER = (String s) -> Integer.valueOf(s.strip());
    public static final Function<String, String> STRING_PARSER = String::strip;
}
