package kakao.dart;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BasicPointTest {

    @Test
    public void 포인트_제한_0에서_20() {
        for (int i = 0; i < 20; i++) {
            new PointNumber(String.valueOf(i));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void 포인트_최대값_초과_21() {
        new PointNumber("21");
    }

    @Test
    public void 보너스_계산() {
        assertThat(2l, is(Bonus.SINGLE.calculate(2)));
        assertThat(4l, is(Bonus.DOUBLE.calculate(2)));
        assertThat(8l, is(Bonus.TRIPLE.calculate(2)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void 포인트_보너스_부재() {
        new BasicPoint("1");
    }

    @Test
    public void 포인트_계산() {
        assertThat(2L, is(new BasicPoint("2S").calculate()));
        assertThat(4L, is(new BasicPoint("2D").calculate()));
        assertThat(8L, is(new BasicPoint("2T").calculate()));
    }

    @Test
    public void 옵션_계산() {
        assertThat(4l, is(Option.STAR.calculate(2)));
        assertThat(-2l, is(Option.ACHA.calculate(2)));

        assertThat(4l, is(new Options(Option.STAR).calculate(2)));
        assertThat(-4l, is(new Options(Option.STAR).add(Option.ACHA).calculate(2)));
        assertThat(-4l, is(new Options(Option.ACHA).add(Option.STAR).calculate(2)));
    }

    @Test
    public void 던지기() {
        assertThat(2L ,is(new Point("2S").calculate()));
        assertThat(-2L ,is(new Point("2S#").calculate()));
        assertThat(8L ,is(new Point("2D*").calculate()));

        assertThat(4L,is(new Point(new BasicPoint("2S"), new Options(Option.STAR)).calculate()));
        assertThat(-2L,is(new Point(new BasicPoint("2S"), new Options(Option.ACHA)).calculate()));
        assertThat(-4L,is(new Point(new BasicPoint("2S"), new Options(Option.STAR).add(Option.ACHA)).calculate()));
    }

    @Test
    public void 점수() {
        assertThat( 37l, is(new Score("1S2D*3T").calculate()));
        assertThat( 9l, is(new Score("1D2S#10S").calculate()));
        assertThat( 3l, is(new Score("1D2S0T").calculate()));
        assertThat( 23l, is(new Score("1S*2T*3S").calculate()));
        assertThat( 5l, is(new Score("1D#2S*3S").calculate()));
        assertThat( -4l, is(new Score("1T2D3D#").calculate()));
        assertThat( 59l, is(new Score("1D2S3T*").calculate()));
    }
}
