package password;

public class DoesNotHaveAnyForbiddenCharactersRule extends PasswordRule{
    private final String allowedSpecialCharacters;

    public DoesNotHaveAnyForbiddenCharactersRule(String allowedSpecialCharacters) {
        this.allowedSpecialCharacters = allowedSpecialCharacters;
    }

    @Override
    boolean validate(String password) {
        return doesNotContainAnyForbiddenCharacterRegex(password);
    }

    private boolean doesNotContainAnyForbiddenCharacterRegex(String passwordString) {
        String pattern = "^[a-zA-Z0-9." + allowedSpecialCharacters + "]+$";
        return passwordString.matches(pattern);
    }
}
