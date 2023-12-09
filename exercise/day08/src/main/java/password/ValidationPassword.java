package password;

import java.util.ArrayList;
import java.util.List;

public class ValidationPassword {
    private final List<PasswordRule> rules;

    public ValidationPassword() {
        rules = new ArrayList<>();
    }

    public boolean validate(String passwordString) {
        return rules.stream()
                .allMatch(r -> r.validate(passwordString));
    }

    public ValidationPassword addValidationRule(PasswordRule rule) {
        rules.add(rule);

        return this;
    }
}
