package ci.dependencies;

public class Project {
    private final boolean buildsSuccessfully;
    private final TestStatus testStatus;

    private Project(boolean buildsSuccessfully, TestStatus testStatus) {
        this.buildsSuccessfully = buildsSuccessfully;
        this.testStatus = testStatus;
    }

    public static ProjectBuilder builder() {
        return new ProjectBuilder();
    }

    public boolean hasTests() {
        return testStatus != TestStatus.NO_TESTS;
    }

    public TaskResult runTests() {
        var testPassed = testStatus == TestStatus.PASSING_TESTS;
        return new TaskResult(
                testStatus == TestStatus.NO_TESTS || testPassed,
                testStatus == TestStatus.NO_TESTS
                        ? "No tests"
                        : testPassed
                            ? "Tests passed" : "Tests failed"
                );
    }

    public TaskResult deploy() {
        return new TaskResult(
                buildsSuccessfully,
                buildsSuccessfully ? "Deployment successful" : "Deployment failed");
    }

    public static class ProjectBuilder {
        private boolean buildsSuccessfully;
        private TestStatus testStatus;

        public ProjectBuilder setTestStatus(TestStatus testStatus) {
            this.testStatus = testStatus;
            return this;
        }

        public ProjectBuilder setDeploysSuccessfully(boolean buildsSuccessfully) {
            this.buildsSuccessfully = buildsSuccessfully;
            return this;
        }

        public Project build() {
            return new Project(buildsSuccessfully, testStatus);
        }
    }
}
