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
        if (cacheSize.same(0)) return new Cache(cacheSize.toInt());

        if (contains(city)) {
            remove(city);
        }

        if (isFull()) {
            remove(lastIndex());
        }

        return addFirst(city);
    }

    public boolean contains(City city) {
        return cities.contains(city);
    }

    private boolean isFull() {
        return cities.size() >= cacheSize.toInt();
    }

    private int lastIndex() {
        return cities.size()-1;
    }

    private Cache addFirst(City city) {
        return new Cache(cacheSize, cities.addFirst(city));
    }

    private Cache remove(City city) {
        return new Cache(cacheSize, cities.remove(city));
    }

    private Cache remove(int index) {
        return new Cache(cacheSize, cities.remove(index));
    }
}