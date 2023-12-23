package games;

public class FizzBuzzNumber {
    public static final int MIN = 0;
    public static final int MAX = 100;
    private final Integer input;

    public FizzBuzzNumber(int input) throws OutOfRangeException {
        if(isOutOfRange(input))
            throw new OutOfRangeException();

        this.input = input;
    }

    private static boolean isOutOfRange(Integer input) {
        return input <= MIN || input > MAX;
    }

    public Integer getInput() {
        return input;
    }
}
