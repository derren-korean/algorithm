package kakao.cache;

public class CityCache {

    private Cache cache;
    private ExecuteResult executeResult;

    public CityCache(Integer cacheSize) {
        cache = new Cache(cacheSize);
        executeResult = new ExecuteResult();
    }

    public int executeTime(String... cities) {
        new Cities(cities).stream().forEachOrdered(this::execute);
        return executeResult.sum();
    }

    private void execute(City city) {
        executeResult.increase(cache.contains(city));
        cache.executeLRU(city);
    }
}