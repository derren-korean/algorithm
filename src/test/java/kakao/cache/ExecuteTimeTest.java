package kakao.cache;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExecuteTimeTest {

    @Test
    public void cacheSize_0_일때() {
        new CacheSize(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void 도시명_글자만() {
        new City("  s d d ");
    }

    @Test
    public void 도시_만들기() {
        new City("seoul");
    }

    @Test
    public void 도시_이름_비교() {
        assertThat(true, is(new City("seoul").same(new City("Seoul"))));
    }

    @Test
    public void 응답시간_포함_1() {
        boolean cacheHit = true;
        assertThat(1, is(new ExecuteResult().increase(cacheHit).sum()));
    }

    @Test
    public void 응답시간_미포함_5() {
        boolean cacheMiss = false;
        assertThat(5, is(new ExecuteResult().increase(cacheMiss).sum()));
    }

    @Test
    public void 도시_포함() {
        Cities cities = new Cities(getStringArr("Jeju", "Pangyo"));
        assertThat(true, is(cities.contains(new City("Jeju"))));
    }

    @Test
    public void 도시_삭제() {
        Cities cities = new Cities(getStringArr("Jeju"))
                .addFirst(new City("aaa"))
                .remove(new City("aaa"));

        assertThat(false, is(cities.contains(new City("aaa"))));
    }

    @Test
    public void 도시_앞쪽으로_추가() {
        Cities cities = new Cities(getStringArr("Jeju"))
                .addFirst(new City("aaa"));
        cities.remove(cities.size()-1);

        assertThat(true, is(cities.contains(new City("aaa"))));
    }

    @Test
    public void 결과_확인() {
        assertThat(50, is(new CityCache(3)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA")
                )));

        assertThat(21, is(new CityCache(3)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul")
                )));

        assertThat(60, is(new CityCache(2)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome","Paris", "Jeju", "NewYork", "Rome")
                )));

        assertThat(52, is(new CityCache(5)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome","Paris", "Jeju", "NewYork", "Rome")
                )));

        assertThat(16, is(new CityCache(2)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "NewYork", "newyork")
                )));

        assertThat(25, is(new CityCache(0)
                .executeTime(
                        getStringArr("Jeju", "Pangyo", "Seoul", "NewYork", "LA")
                )));
    }

    private String[] getStringArr(String... strings) {
        return Arrays.asList(strings).stream().toArray(String[]::new);
    }
}
