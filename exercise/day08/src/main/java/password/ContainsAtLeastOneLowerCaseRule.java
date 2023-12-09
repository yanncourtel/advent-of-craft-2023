package password;

public class ContainsAtLeastOneLowerCaseRule extends PasswordRule {
    @Override
    boolean validate(String password) {
        return containsLowerCase(password);
    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }
}
