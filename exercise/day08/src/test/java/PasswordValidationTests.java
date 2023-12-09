import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import password.ValidationPassword;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationTests {

    public static Stream<Arguments> invalidPasswords() {
        return Stream.of(
            Arguments.of("Pass", "Contains at least 8 characters"),
            Arguments.of("passwordddd", "Contains at least one capital letter"),
            Arguments.of("PPPPPPPPPPPP", "Contains at least one lowercase letter"),
            Arguments.of("Passworddd", "Contains at least a number"),
            Arguments.of("Pass12rddd", "Contains at least a special character in this list `. * # @ $ % &`"),
            Arguments.of("P@ss12rddd!", "Any other characters are not authorized."),
            Arguments.of("P@ss12rddd````", "Any other characters are not authorized.")
        );
    }

    @Test
    void passwordValid() {
        var validationPassword = new ValidationPassword();

        assertTrue(validationPassword.validate("P@ssw0rd"));
    }

    @ParameterizedTest
    @MethodSource("invalidPasswords")
    void passwordIsInvalid(String invalidPassword) {
        var validationPassword = new ValidationPassword();

        assertFalse(validationPassword.validate(invalidPassword));
    }
}
