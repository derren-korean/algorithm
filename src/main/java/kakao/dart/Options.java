package kakao.dart;

import java.util.ArrayList;
import java.util.List;

public class Options {
    private List<Option> options;

    public Options(List<Option> options) {
        if (options == null) throw new IllegalArgumentException();
        this.options = options;
    }

    public Options(Option option) {
        options = new ArrayList<>();
        options.add(option);
    }

    public Options add(Option option) {
        options.add(option);
        return new Options(options);
    }

    public Option unique() {
        if (options.size() != 1) throw new IllegalStateException();
        return options.get(0);
    }

    public long calculate(long value) {
        for (int i = 0; i < options.size(); i++) {
            value = options.get(i).calculate(value);
        }
        return value;
    }
}