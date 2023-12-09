package password;

public class ContainsAtLeastOneAllowedSpecialCharacterRule extends PasswordRule {

    private final String allowedSpecialCharacters;

    public ContainsAtLeastOneAllowedSpecialCharacterRule(String allowedSpecialCharacters) {
        this.allowedSpecialCharacters = allowedSpecialCharacters;
    }

    @Override
    boolean validate(String password) {
        return containsAllowedSpecialCharacter(password);
    }

    private boolean containsAllowedSpecialCharacter(String value) {
        return contains(value, i -> allowedSpecialCharacters.indexOf(i) != -1);
    }
}
