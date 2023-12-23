package games;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FizzBuzz {
    public static final int FIZZ = 3;
    public static final int BUZZ = 5;
    public static final int FIZZBUZZ = 15;

    public static Map<Predicate<Integer>, Function<Integer, String>> fizzBuzzMap = new LinkedHashMap<>();

    static {
        fizzBuzzMap.put(i -> is(FIZZBUZZ, i), i -> "FizzBuzz");
        fizzBuzzMap.put(i -> is(FIZZ, i), i -> "Fizz");
        fizzBuzzMap.put(i -> is(BUZZ, i), i -> "Buzz");
        fizzBuzzMap.put(i -> true, Object::toString);
    }

    private FizzBuzz() {
    }

    public static Optional<String> convert(FizzBuzzNumber number) {
        return fizzBuzzMap.entrySet()
                .stream()
                .filter(f -> f.getKey().test(number.getInput()))
                .findFirst()
                .map(f -> f.getValue().apply(number.getInput()));
    }

    private static boolean is(Integer divisor, Integer input) {
        return input % divisor == 0;
    }

}
