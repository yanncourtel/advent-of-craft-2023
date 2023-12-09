package password;

public class ContainsAtLeastOneUpperCaseRule extends PasswordRule {
    @Override
    public boolean validate(String password) {
        return containsUpperCase(password);
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }
}
