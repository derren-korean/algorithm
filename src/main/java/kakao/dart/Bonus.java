package kakao.dart;

import java.util.Arrays;
import java.util.function.Function;

public enum Bonus {
    SINGLE("S", value -> value),
    DOUBLE("D", value -> (long) Math.pow(value, 2)),
    TRIPLE("T", value -> (long) Math.pow(value, 3));

    private String shortName;
    private Function<Long, Long> expression;

    Bonus(String shortName, Function<Long, Long> expression) {
        this.shortName = shortName;
        this.expression = expression;
    }

    public long calculate(long value) {return expression.apply(value);}

    public static Bonus getByShortName(String shortName) {
        return Arrays.asList(Bonus.values()).stream()
                .filter(bonus -> bonus.shortName.equals(shortName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}