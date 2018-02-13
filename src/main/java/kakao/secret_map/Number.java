package kakao.secret_map;

public class Number {

    private Integer decimal;

    public Number(Integer decimal) {
        if (decimal == null) throw new IllegalArgumentException();
        this.decimal = decimal;
    }

    public BinaryString toBinary() {
        return new BinaryString(decimal);
    }

    public Number orWise(Number number) {
        return new Number(decimal | number.decimal);
    }

    @Override
    public String toString() {
        return toBinary().toString();
    }
}