package games;

public class FizzBuzz {

    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 100;

    private FizzBuzz() {
    }
    
    public static String convert(Integer input) throws OutOfRangeException {
        if (isInputInRange(input)) {
            throw new OutOfRangeException();
        }

        if (input % 3 == 0 && input % 5 == 0) {
            return "FizzBuzz";
        }

        if (input % 3 == 0) {
            return "Fizz";
        }

        if (input % 5 == 0) {
            return "Buzz";
        }

        return input.toString();
    }

    private static boolean isInputInRange(Integer input) {
        return input <= MIN_RANGE || input > MAX_RANGE;
    }
}
