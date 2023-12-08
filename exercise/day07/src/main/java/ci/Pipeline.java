package ci;

import ci.dependencies.Logger;
import ci.dependencies.Project;

public class Pipeline {
    private final EmailSender emailSender;
    private final Logger log;

    public Pipeline(EmailSender emailSender, Logger log) {
        this.emailSender = emailSender;
        this.log = log;
    }

    public void run(Project project) {
        if (runningTestHasFailed(project) || deployHasFailed(project)) {
            return;
        }

        emailSender.send("Deployment completed successfully");
    }

    private boolean deployHasFailed(Project project) {
        return project.deploy()
                .logStatusWith(log)
                .reportByEmail(emailSender)
                .isUnsuccessful();
    }

    private boolean runningTestHasFailed(Project project) {
        return project.runTests()
                .logStatusWith(log)
                .reportByEmail(emailSender)
                .isUnsuccessful();
    }
}
