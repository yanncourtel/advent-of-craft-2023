import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import password.ValidationPassword;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidationTests {
    /*
-- Contains at least 8 characters
-- Contains at least one capital letter
- Contains at least one lowercase letter
- Contains at least a number
- Contains at least a special character in this list `. * # @ $ % &`.
- Any other characters are not authorized.
    */

    public static Stream<Arguments> invalidPassword() {
        return Stream.of(
                Arguments.of("P@ssw", "Contains at least 8 characters"),
                Arguments.of("passwordddd", "Contains at least one capital letter")
        );
    }

    @Test
    void passwordValid() {
        var validationPassword = new ValidationPassword();

        assertTrue(validationPassword.validate("P@ssw0rd"));
    }

    @ParameterizedTest
    @MethodSource("invalidPassword")
    void passwordIsInvalid(String invalidPassword) {
        var validationPassword = new ValidationPassword();

        assertFalse(validationPassword.validate(invalidPassword));
    }
}
