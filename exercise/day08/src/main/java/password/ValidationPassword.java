package password;

import java.util.function.IntPredicate;

public class ValidationPassword {
    public static final int MINIMUM_PASSWORD_SIZE = 8;
    private final char[] allowedSpecialCharacters = {'.', '*', '#', '@', '$', '%', '&'};

    public boolean validate(String passwordString) {
        return hasMinimumSize(passwordString)
                && containsUpperCase(passwordString)
                && containsLowerCase(passwordString)
                && containsNumber(passwordString)
                && containsAllowedSpecialCharacter(passwordString)
                && doesNotContainAnyForbiddenCharacter(passwordString);
    }

    private boolean doesNotContainAnyForbiddenCharacter(String passwordString) {
        return !contains(passwordString, i -> i == '!');
    }

    private static boolean hasMinimumSize(String passwordString) {
        return passwordString.length() >= MINIMUM_PASSWORD_SIZE;
    }

    private boolean containsAllowedSpecialCharacter(String value) {
        return contains(value, i -> (new String(allowedSpecialCharacters)).indexOf(i) != -1);
    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
