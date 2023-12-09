package password;

public class ContainsAtLeastANumber extends PasswordRule {
    @Override
    boolean validate(String password) {
        return containsNumber(password);
    }
    private boolean containsNumber(String value) {
        return contains(value, Character::isDigit);
    }
}
