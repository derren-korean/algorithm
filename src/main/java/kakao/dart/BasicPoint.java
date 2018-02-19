package kakao.dart;

import java.util.Optional;

public class BasicPoint {

    private static final String POINT_MATCH = "[^\\d]{1,2}";

    private PointNumber pointNumber;
    private Bonus bonus;

    public BasicPoint(String text) {
        if (text == null || text.isEmpty()) throw new IllegalStateException();
        pointNumber = matchPoint(text);
        bonus = matchArea(text);
    }

    private PointNumber matchPoint(String text) {
        return new PointNumber(Optional.of(text.split(POINT_MATCH)).orElseThrow(IllegalArgumentException::new)[0]);
    }

    private Bonus matchArea(String text) {
        return Bonus.getByShortName(text.substring(text.length()-1));
    }

    public Long calculate() {
        return bonus.calculate(pointNumber.toLong());
    }
}