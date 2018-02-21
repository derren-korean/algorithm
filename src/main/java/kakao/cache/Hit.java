package kakao.cache;

    public class Hit implements Number {

    private Integer count;

    public Hit(Integer count) {
        this.count = count;
    }

    @Override
    public Hit increase() {
        return new Hit(++count);
    }

    @Override
    public int sum() {
        return count;
    }
}