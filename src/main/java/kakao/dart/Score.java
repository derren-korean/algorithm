package kakao.dart;

import java.util.ArrayList;
import java.util.List;

public class Score {
    List<Point> score;

    public Score(String text) {
        if (text == null || text.isEmpty()) throw new IllegalArgumentException();
        score = new ArrayList<>();
        fillScore(text);
    }

    private void fillScore(String text) {
        String[] tokens = text.split("[^\\d]{1,2}");
        int index = 1;
        while(index < tokens.length) {
            String point = text.substring(0, text.indexOf(tokens[index++]));
            add(new Point(point));
            text = text.substring(point.length());
        }
        add(new Point(text));
    }

    private void add(Point point) {
        if (point.has(Option.STAR) && score.size() != 0) {
            int prevIndex = score.size() - 1;
            Point previous = score.get(prevIndex);

            score.set(prevIndex, previous.addOption(point));
        }
        score.add(point);
    }

    public long calculate() {
        return score.stream().mapToLong(Point::calculate).sum();
    }
}