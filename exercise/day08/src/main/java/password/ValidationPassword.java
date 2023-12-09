package password;

import java.util.function.IntPredicate;

public class ValidationPassword {
    public boolean validate(String passwordString) {
        return passwordString.length() >= 8
                && containsUpperCase(passwordString)
                && containsLowerCase(passwordString);
    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
