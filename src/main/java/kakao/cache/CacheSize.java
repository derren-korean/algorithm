package kakao.cache;

public class CacheSize {
    private static final int MAX_SIZE = 31;

    private Integer size;

    public CacheSize(Integer size) {
        if (size < 0 || size > MAX_SIZE) throw new IllegalArgumentException();
        this.size = size;
    }

    public int toInt() {
        return size;
    }

    public boolean same(int number) {
        return size == number;
    }
}