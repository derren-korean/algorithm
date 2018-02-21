package kakao.cache;

 public class ExecuteResult {

    private Hit hit;
    private Miss miss;

    public ExecuteResult() {
        this.hit = new Hit(0);
        this.miss = new Miss(0);
    }

    public ExecuteResult(Hit hit, Miss miss) {
        this.hit = hit;
        this.miss = miss;
    }

    public ExecuteResult increase(boolean isHit) {
        if (isHit) {
            hit = hit.increase();
        } else {
            miss = miss.increase();
        }
        return new ExecuteResult(hit, miss);
    }

    public int sum() {
        return hit.sum() + miss.sum();
    }
}