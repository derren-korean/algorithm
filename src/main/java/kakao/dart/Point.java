package kakao.dart;

import java.util.ArrayList;

public class Point {

    private BasicPoint basicPoint;
    private Options options;

    public Point(String text) {
        if (Option.hasOption(text)) {
            String option = text.substring(text.length()-1);
            options = new Options(Option.getByShortName(option));

            text = text.substring(0, text.indexOf(option));
        }
        basicPoint = new BasicPoint(text);
    }

    public Point(BasicPoint basicPoint, Options options) {
        this.basicPoint = basicPoint;
        this.options = options;
    }

    public Point addOption(Point aPoint) {
        if (options == null) {
            options = new Options(new ArrayList<>());
        }
        return new Point(basicPoint, options.add(aPoint.options.unique()));
    }

    public boolean hasStarOption() {
        return options != null && Option.STAR == options.unique();
    }

    public long calculate() {
        if (options == null) return basicPoint.calculate();
        return options.calculate(basicPoint.calculate());
    }
}