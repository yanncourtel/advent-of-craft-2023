package ci.dependencies;

import java.util.function.Supplier;

public class DeployTaskResult extends TaskResult {

    @Override
    public String getStatusMessage() {
        return success ? "Deployment successful" : "Deployment failed";
    }

    public DeployTaskResult(Supplier<Boolean> deploySuccessful) {
        super(deploySuccessful
        );
    }
}
