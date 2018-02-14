package kakao.dart;

public class PointNumber {

    private static final Long MIN_NUMBER = 0l;
    private static final Long MAX_NUMBER = 20l;

    private Long number;

    public PointNumber(String numeric) {
        if (numeric == null) throw new IllegalArgumentException();
        Long number = Long.valueOf(numeric);
        if (outOfNumber(number)) throw new IllegalArgumentException();

        this.number = number;
    }

    private boolean outOfNumber(Long number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }

    public long toLong() {
        return number;
    }
}