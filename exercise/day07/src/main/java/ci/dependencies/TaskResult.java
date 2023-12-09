package ci.dependencies;

import ci.EmailSender;

import java.util.function.Supplier;

public abstract class TaskResult {

    protected final boolean success;

    public abstract String getStatusMessage();

    public TaskResult(Supplier<Boolean> success){
        this.success = success.get();
    }

    public boolean isUnsuccessful() {
        return !success;
    }

    public boolean isSuccessful() {
        return success;
    }

    public TaskResult logStatusWith(Logger log) {
        if (success)
            log.info(getStatusMessage());
        else
            log.error(getStatusMessage());

        return this;
    }

    public TaskResult reportByEmail(EmailSender emailSender) {
        if (!success)
            emailSender.send(getStatusMessage());

        return this;
    }
}
