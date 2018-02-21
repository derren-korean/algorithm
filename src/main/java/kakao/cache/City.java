package kakao.cache;

public class City {
    private static final int MAX_LENGTH = 21;

    private String city;

    public City(String city) {
        if (city == null || city.isEmpty() || city.length() > MAX_LENGTH) throw new IllegalArgumentException();
        if (!city.matches("^[a-zA-Z]*$")) throw new IllegalArgumentException();

        this.city = city.trim().toLowerCase();
    }

    public boolean same(City city) {
        if (city == null) return false;
        return this.city.toString().equals(city.toString());
    }

    @Override
    public String toString() {
        return city;
    }
}