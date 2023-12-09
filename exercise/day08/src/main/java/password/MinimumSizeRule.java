package password;

public class MinimumSizeRule extends PasswordRule {
    private final int minimumSize;

    public MinimumSizeRule(int minimumSize) {
        super();
        this.minimumSize = minimumSize;
    }

    @Override
    public boolean validate(String password) {
        return hasMinimumSize(password);
    }

    private boolean hasMinimumSize(String passwordString) {
        return passwordString.length() >= minimumSize;
    }
}
