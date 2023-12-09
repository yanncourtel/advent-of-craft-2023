import org.junit.jupiter.api.Test;
import password.ValidationPassword;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidationTests {
    /*
- Contains at least 8 characters
- Contains at least one capital letter
- Contains at least one lowercase letter
- Contains at least a number
- Contains at least a special character in this list `. * # @ $ % &`.
- Any other characters are not authorized.
    */

    @Test
    void passwordValid() {
        var validationPassword = new ValidationPassword();

        assertTrue(validationPassword.validate("P@ssw0rd!"));
    }
}
