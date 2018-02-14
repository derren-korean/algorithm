package kakao.dart;

import java.util.Arrays;
import java.util.function.Function;

public enum Option {
    STAR("*", value -> value * 2),
    ACHA("#", value -> -value);

    private String shortName;
    private Function<Long, Long> expression;

    Option(String shortName, Function<Long, Long> expression) {
        this.shortName = shortName;
        this.expression = expression;
    }

    public long calculate(long value) {
        return expression.apply(value);
    }

    public static boolean hasOption(String text) {
        return Arrays.asList(Option.values()).stream()
                .map(option -> option.shortName)
                .anyMatch(shortName -> text.indexOf(shortName) > -1);
    }

    public static Option getByShortName(String shortName) {
        return Arrays.asList(Option.values()).stream()
                .filter(option -> option.shortName.equals(shortName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}