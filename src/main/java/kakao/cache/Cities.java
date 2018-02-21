package kakao.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cities {
    private static final int MAX_LENGTH = 100001;
    private List<City> cities;

    public Cities() {
        cities = new ArrayList<>();
    }

    public Cities(String... cities) {
        if (cities == null) throw new IllegalArgumentException();
        make(Arrays.asList(cities).stream()
                .map(City::new)
                .collect(Collectors.toList()));
    }

    public Cities(List<City> cities) {
        if (cities == null) throw new IllegalArgumentException();
        make(cities);
    }

    private void make(List<City> cities) {
        if (cities.size() == 0 || cities.size() > MAX_LENGTH) throw new IllegalArgumentException();
        this.cities = new ArrayList<>();
        this.cities.addAll(cities);
    }

    public Cities addFirst(City city) {
        cities.add(0, city);
        return new Cities(cities);
    }

    public int size() {
        return cities.size();
    }

    public boolean contains(City city) {
        return cities.stream().anyMatch(_city -> _city.same(city));
    }

    public Stream<City> stream() {
        return cities.stream();
    }

    public Cities remove(City city) {
        return remove(indexOf(city));
    }

    public Cities remove(int index) {
        cities.remove(index);
        return new Cities(cities);
    }

    private int indexOf(City city) {
        int index = 0;
        while (index < cities.size()) {
            if (cities.get(index++).same(city)) break;
        }
        return --index;
    }
}