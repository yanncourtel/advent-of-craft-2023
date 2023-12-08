package ci.dependencies;

import ci.EmailSender;

public record TaskResult(boolean success, String status) {

    public boolean isUnsuccessful() {
        return !success;
    }

    public TaskResult logStatusWith(Logger log) {
        if (success)
            log.info(status);
        else
            log.error(status);

        return this;
    }

    public TaskResult reportByEmail(EmailSender emailSender) {
        if (!success)
            emailSender.send(status);

        return this;
    }
}
