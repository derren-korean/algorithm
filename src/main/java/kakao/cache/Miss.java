package kakao.cache;

    public class Miss implements Number {

    private Integer count;

    public Miss(Integer count) {
        this.count = count;
    }

    @Override
    public Miss increase() {
        return new Miss(count + 5);
    }

    @Override
    public int toInt() {
        return count;
    }
}