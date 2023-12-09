package password;

public class MinimumSizeRule extends PasswordRule {
    private static final int MINIMUM_PASSWORD_SIZE = 8;

    @Override
    public boolean validate(String password) {
        return hasMinimumSize(password);
    }

    private static boolean hasMinimumSize(String passwordString) {
        return passwordString.length() >= MINIMUM_PASSWORD_SIZE;
    }
}
