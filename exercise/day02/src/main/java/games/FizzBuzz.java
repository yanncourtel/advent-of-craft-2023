package games;

public class FizzBuzz {

    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 100;
    public static final int FIZZ_MULTIPLE = 3;
    public static final int BUZZ_MULTIPLE = 5;
    public static final String FIZZ_STRING = "Fizz";
    public static final String BUZZ_STRING = "Buzz";

    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        checkInputIsInRange(input);

        if (isFizzBuzz(input)) {
            return FIZZ_STRING + BUZZ_STRING;
        }

        if (isFizz(input)) {
            return FIZZ_STRING;
        }

        if (isBuzz(input)) {
            return BUZZ_STRING;
        }

        return input.toString();
    }

    private static void checkInputIsInRange(Integer input) throws OutOfRangeException {
        if (input <= MIN_RANGE || input > MAX_RANGE) {
            throw new OutOfRangeException();
        }
    }

    private static boolean isFizzBuzz(Integer input) {
        return isFizz(input) && isBuzz(input);
    }

    private static boolean isFizz(Integer input) {
        return input % FIZZ_MULTIPLE == 0;
    }

    private static boolean isBuzz(Integer input) {
        return input % BUZZ_MULTIPLE == 0;
    }
}
