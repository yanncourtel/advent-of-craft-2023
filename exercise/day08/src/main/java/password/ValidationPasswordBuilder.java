package password;

import java.util.ArrayList;
import java.util.List;

public class ValidationPasswordBuilder {

    public static ValidationPasswordBuilder aValidationPassword(){
        return new ValidationPasswordBuilder();
    }
    private final List<PasswordRule> rules = new ArrayList<>();
    
    public ValidationPasswordBuilder withStandardRules() {
        var allowedSpecialCharacters = ".*#@$%&";
        rules.add(new MinimumSizeRule(8));
        rules.add(new ContainsAtLeastOneUpperCaseRule());
        rules.add(new ContainsAtLeastOneLowerCaseRule());
        rules.add(new ContainsAtLeastANumberRule());
        rules.add(new ContainsAtLeastOneAllowedSpecialCharacterRule(allowedSpecialCharacters));
        rules.add(new DoesNotHaveAnyForbiddenCharactersRule(allowedSpecialCharacters));
        
        return this;
    }

    public ValidationPassword build() {
        return new ValidationPassword(rules);
    }
}
