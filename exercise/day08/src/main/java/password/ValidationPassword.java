package password;

import java.util.List;
import java.util.function.IntPredicate;

public class ValidationPassword {
    public static final int MINIMUM_PASSWORD_SIZE = 8;
    private final String allowedSpecialCharacters = ".*#@$%&";

    private final List<PasswordRule> rules = List.of(
            new MinimumSizeRule(),
            new ContainsAtLeastOneUpperCaseRule(),
            new ContainsAtLeastOneLowerCaseRule(),
            new ContainsAtLeastANumber()

    );

    public boolean validate(String passwordString) {
        return rules.stream().allMatch(r -> r.validate(passwordString))
                //&& containsUpperCase(passwordString)
                //&& containsLowerCase(passwordString)
                //&& containsNumber(passwordString)
                && containsAllowedSpecialCharacter(passwordString)
                && doesNotContainAnyForbiddenCharacter(passwordString);
    }

    private static boolean hasMinimumSize(String passwordString) {
        return passwordString.length() >= MINIMUM_PASSWORD_SIZE;
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }

    private boolean containsAllowedSpecialCharacter(String value) {
        return contains(value, i -> allowedSpecialCharacters.indexOf(i) != -1);
    }

    private boolean doesNotContainAnyForbiddenCharacter(String passwordString) {
        return !contains(passwordString,
                i -> !Character.isLetter(i)
                        && !Character.isLowerCase(i)
                        && !Character.isUpperCase(i)
                        && allowedSpecialCharacters.indexOf(i) == -1
                        && !Character.isDigit(i));
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
