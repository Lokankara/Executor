package executor.service.service.step;

import java.util.Arrays;

public enum StepExecutionType {
    CLICKXPATH(new ClickXpathStepExecution(Action.CLICK_XPATH_ACTION)),
    CLICKCSS(new ClickCssStepExecution(Action.CLICK_CSS_ACTION)),
    SLEEP(new SleepStepExecution(Action.SLEEP_ACTION)),
    UNSUPPORTED(new UnsupportedStepExecution(Action.UNSUPPORTED_ACTION));
    private final StepExecution stepExecution;

    StepExecutionType(final StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    public StepExecution getStepExecution() {
        return this.stepExecution;
    }

    public static StepExecutionType fromString(final String action) {
        return Arrays
                .stream(StepExecutionType.values())
                .filter(type -> type.name().equals(action.toUpperCase()))
                .findFirst()
                .orElse(UNSUPPORTED);
    }
}
