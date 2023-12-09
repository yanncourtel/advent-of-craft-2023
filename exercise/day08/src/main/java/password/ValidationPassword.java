package password;

public class ValidationPassword {
    public boolean validate(String passwordString) {
        if (passwordString.length() < 8)
            return false;
        return true;
    }
}
