package ci;

import ci.dependencies.Config;
import ci.dependencies.Emailer;
import ci.dependencies.Logger;

public class EmailSender {
    private final Logger log;
    private final Config config;
    private final Emailer emailer;

    public EmailSender(Logger log, Config config, Emailer emailer) {
        this.log = log;
        this.config = config;
        this.emailer = emailer;
    }

    public void send(String emailContent) {
        if (config.sendEmailSummary()) {
            log.info("Sending email");
            emailer.send(emailContent);
        } else {
            log.info("Email disabled");
        }
    }
}
