package kakao.secret_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Numbers {
    private List<Number> numbers;

    public Numbers(Integer... numberArr) {
        numbers = Arrays.asList(Optional.of(numberArr).orElseThrow(IllegalArgumentException::new))
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Numbers orWise(Numbers numbers) {
        if (this.numbers.size() != numbers.numbers.size()) throw new IllegalArgumentException();
        List<Number> _temp = new ArrayList();

        for (int i = 0; i < this.numbers.size(); i++) {
            _temp.add(this.numbers.get(i).orWise(numbers.numbers.get(i)));
        }
        return new Numbers(_temp);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}