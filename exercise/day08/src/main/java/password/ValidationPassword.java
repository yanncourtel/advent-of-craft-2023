package password;

import java.util.List;

public class ValidationPassword {

    private final String allowedSpecialCharacters = ".*#@$%&";

    private final List<PasswordRule> rules = List.of(
            new MinimumSizeRule(),
            new ContainsAtLeastOneUpperCaseRule(),
            new ContainsAtLeastOneLowerCaseRule(),
            new ContainsAtLeastANumberRule(),
            new ContainsAtLeastOneAllowedSpecialCharacterRule(allowedSpecialCharacters),
            new DoesNotHaveAnyForbiddenCharactersRule(allowedSpecialCharacters)
    );

    public boolean validate(String passwordString) {
        return rules.stream().allMatch(r -> r.validate(passwordString));
    }
}
