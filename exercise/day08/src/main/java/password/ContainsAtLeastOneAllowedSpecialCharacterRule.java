package password;

public class ContainsAtLeastOneAllowedSpecialCharacterRule extends PasswordRule {

    private final String allowedSpecialCharacters = ".*#@$%&";

    @Override
    boolean validate(String password) {
        return containsAllowedSpecialCharacter(password);
    }

    private boolean containsAllowedSpecialCharacter(String value) {
        return contains(value, i -> allowedSpecialCharacters.indexOf(i) != -1);
    }
}
