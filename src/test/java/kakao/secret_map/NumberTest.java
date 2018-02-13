package kakao.secret_map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberTest {

    @Test
    public void 진수_변환() {

        assertEquals("#  #", new BinaryString(9).toString());

        assertEquals("#### ", new Number(30).toString());

        assertEquals("#####", new Number(30).orWise(new Number(9)).toString());
    }

    @Test
    public void 여러개의_진수_변환() {
        Numbers numbers = new Numbers(10, 20, 30, 40, 50);
        System.out.println(numbers);

        System.out.println(new Numbers(9, 20, 28, 18, 11).orWise(new Numbers(30, 1, 21, 17, 28)));
    }
}
