package password;

import java.util.function.IntPredicate;

public abstract class PasswordRule {
    abstract boolean validate(String password);

    protected boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

}
