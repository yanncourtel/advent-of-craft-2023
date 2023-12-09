package ci;

import ci.dependencies.Logger;
import ci.dependencies.TaskResult;

import java.util.stream.Stream;

public class Pipeline {
    private final EmailSender emailSender;
    private final Logger log;
    private final Stream<TaskResult> pipelineTasks;

    public Pipeline(EmailSender emailSender, Logger log, Stream<TaskResult> pipelineTasks) {
        this.emailSender = emailSender;
        this.log = log;
        this.pipelineTasks = pipelineTasks;
    }

    public void run() {
        if (pipelineTasks.noneMatch(this::taskHasFailed))
            emailSender.send("Deployment completed successfully");
    }

    private boolean taskHasFailed(TaskResult task) {
        return task
                .logStatusWith(log)
                .reportByEmail(emailSender)
                .isUnsuccessful();
    }
}
