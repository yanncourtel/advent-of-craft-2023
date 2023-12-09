package password;

import java.util.List;

public class ValidationPassword {

    private final List<PasswordRule> rules = List.of(
            new MinimumSizeRule(),
            new ContainsAtLeastOneUpperCaseRule(),
            new ContainsAtLeastOneLowerCaseRule(),
            new ContainsAtLeastANumberRule(),
            new ContainsAtLeastOneAllowedSpecialCharacterRule()
    );

    public boolean validate(String passwordString) {
        return rules.stream().allMatch(r -> r.validate(passwordString))
                && doesNotContainAnyForbiddenCharacterRegex(passwordString);
    }

    private boolean doesNotContainAnyForbiddenCharacterRegex(String passwordString) {
        String pattern = "^[a-zA-Z0-9.*#@$%&]+$";
        return passwordString.matches(pattern);
    }
}
