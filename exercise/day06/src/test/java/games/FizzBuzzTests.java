package games;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FizzBuzzTests {

    @Nested class ConvertDoesNotAccept {

        public static Stream<Arguments> invalidNumberScenarios() {
            return Stream.of(
                    Arguments.of(0),
                    Arguments.of(-1),
                    Arguments.of(101)
            );
        }

        @ParameterizedTest
        @MethodSource("invalidNumberScenarios")
        void invalidNumbers(int input) {
            assertThatThrownBy(() -> FizzBuzz.convert(input))
                    .isInstanceOf(OutOfRangeException.class);
        }
    }

    @Nested class ConvertReturns {

        public static Stream<Arguments> givenNumberScenarios() {
            return Stream.of(
                    Arguments.of(1, "1"),
                    Arguments.of(67, "67"),
                    Arguments.of(82, "82")
            );
        }

        @ParameterizedTest
        @MethodSource("givenNumberScenarios")
        void givenNumber(int input, String expectedOutput) throws OutOfRangeException {
            assertThat(FizzBuzz.convert(input))
                    .isEqualTo(expectedOutput);
        }



        @ParameterizedTest
        @ValueSource(ints = {3, 66, 99})
        void fizz(int input) throws OutOfRangeException {
            assertThat(FizzBuzz.convert(input))
                    .isEqualTo("Fizz");
        }

        @ParameterizedTest
        @ValueSource(ints = {5, 50, 85})
        void buzz(int input) throws OutOfRangeException {
            assertThat(FizzBuzz.convert(input))
                    .isEqualTo("Buzz");
        }

        @ParameterizedTest
        @ValueSource(ints = {15, 30, 45})
        void fizzBuzz(int input) throws OutOfRangeException {
            assertThat(FizzBuzz.convert(input))
                    .isEqualTo("FizzBuzz");
        }
    }
}