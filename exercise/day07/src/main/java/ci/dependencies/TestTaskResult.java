package ci.dependencies;

import java.util.function.Supplier;

public class TestTaskResult extends TaskResult {

    private final boolean noTests;

    public TestTaskResult(Supplier<Boolean> testPassed, boolean noTests) {
        super(testPassed);

        this.noTests = noTests;
    }

    @Override
    public String getStatusMessage() {
        return noTests
                ? "No tests"
                : success
                    ? "Tests passed"
                    : "Tests failed";
    }
}
