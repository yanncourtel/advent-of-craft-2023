package password;

import java.util.List;

public class ValidationPassword {
    private final List<PasswordRule> rules;

    public ValidationPassword(List<PasswordRule> rules) {
        this.rules = rules;
    }

    public boolean validate(String passwordString) {
        return rules.stream()
                .allMatch(r -> r.validate(passwordString));
    }
}
