package kakao.cache;

public class Cache {

    private CacheSize cacheSize;
    private Cities cities;

    public Cache(CacheSize cacheSize, Cities cities) {
        this.cacheSize = cacheSize;
        this.cities = cities;
    }

    public Cache(Integer cacheSize) {
        this.cacheSize = new CacheSize(cacheSize);
        cities = new Cities();
    }

    public Cache executeLRU(City city) {
        if (contains(city)) {
            remove(city);
        }

        if (isFull()) {
            remove(lastIndex());
        }

        return addFirst(city);
    }

    public boolean isFull() {
        if (cacheSize.same(0)) return false;
        return cities.size() >= cacheSize.toInt();
    }

    public int lastIndex() {
        return cities.size()-1;
    }

    public boolean contains(City city) {
        return cities.contains(city);
    }

    public Cache addFirst(City city) {
        return new Cache(cacheSize, cities.addFirst(city));
    }

    public Cache remove(City city) {
        return new Cache(cacheSize, cities.remove(city));
    }

    public Cache remove(int index) {
        return new Cache(cacheSize, cities.remove(index));
    }
}