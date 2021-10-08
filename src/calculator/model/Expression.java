package calculator.model;

public class Expression {
    private final double FIRST_NUMBER, SECOND_NUMBER;
    private final Sign SIGN;

    public Expression(double FIRST_NUMBER, double SECOND_NUMBER, Sign SIGN) {
        this.FIRST_NUMBER = FIRST_NUMBER;
        this.SECOND_NUMBER = SECOND_NUMBER;
        this.SIGN = SIGN;
    }

    public enum Sign {
        PLUS, MINUS
    }

    public double getFIRST_NUMBER() {
        return FIRST_NUMBER;
    }

    public double getSECOND_NUMBER() {
        return SECOND_NUMBER;
    }

    public Sign getSIGN() {
        return SIGN;
    }
}
