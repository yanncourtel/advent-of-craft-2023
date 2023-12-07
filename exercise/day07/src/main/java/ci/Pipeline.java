package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;
import ci.dependencies.Project;

public class Pipeline {
    private final Config config;
    private final Emailer emailer;
    private final Logger log;

    public Pipeline(Config config, Emailer emailer, Logger log) {
        this.config = config;
        this.emailer = emailer;
        this.log = log;
    }

    public void run(Project project) {

        if(!checkTestsHavePassed(project)){
            log.error("Tests failed");
            sendEmailNew("Tests failed");
            return;
        }

        if(!checkDeploymentIsSuccessful(project)){
            log.error("Deployment failed");
            sendEmailNew("Deployment failed");
            return;
        }

        sendEmailNew("Deployment completed successfully");
    }

    private void sendEmailNew(String emailContent) {
        if (config.sendEmailSummary()) {
            log.info("Sending email");
            emailer.send(emailContent);
        } else {
            log.info("Email disabled");
        }
    }

    private boolean checkTestsHavePassed(Project project) {
        boolean testsPassed;
        if (project.hasTests()) {
            if (!"success".equals(project.runTests())) {
                testsPassed = false;
            } else {
                log.info("Tests passed");
                testsPassed = true;
            }
        } else {
            log.info("No tests");
            testsPassed = true;
        }
        return testsPassed;
    }

    private boolean checkDeploymentIsSuccessful(Project project) {
        boolean deploySuccessful;
        if ("success".equals(project.deploy())) {
            log.info("Deployment successful");
            deploySuccessful = true;
        } else {
            deploySuccessful = false;
        }

        return deploySuccessful;
    }
}
