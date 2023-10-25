package executor.service.service.execution;

import java.util.Arrays;

import static executor.service.service.execution.Action.*;

public enum StepExecutionType {
    CLICK_XPATH(new ClickXpathStepExecution(CLICK_XPATH_ACTION)),
    CLICK_CSS(new ClickCssStepExecution(CLICK_CSS_ACTION)),
    SLEEP(new SleepStepExecution(SLEEP_ACTION)),
    UNSUPPORTED(new UnsupportedStepExecution());

    private final StepExecution stepExecution;

    StepExecutionType(
            final StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    public static StepExecutionType fromString(
            final String action) {
        return Arrays
                .stream(StepExecutionType.values())
                .filter(type -> type.name().equalsIgnoreCase(action))
                .findFirst()
                .orElse(UNSUPPORTED);
    }

    public StepExecution getStepExecution() {
        return this.stepExecution;
    }
}
