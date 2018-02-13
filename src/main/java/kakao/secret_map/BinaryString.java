package kakao.secret_map;

public class BinaryString {

    private String binaryValue;

    private final static String BLINK_STRING = " ";
    private final static String WALL_STRING = "#";

    public BinaryString(int decimal) {
        this.binaryValue = Integer.toBinaryString(decimal)
                .replaceAll("0", BLINK_STRING)
                .replaceAll("1", WALL_STRING);
    }

    @Override
    public String toString() {
        return binaryValue;
    }
}
