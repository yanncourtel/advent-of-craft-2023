package password;

public class ValidationPassword {
    public boolean validate(String passwordString) {
        return passwordString.length() >= 8;
    }
}
