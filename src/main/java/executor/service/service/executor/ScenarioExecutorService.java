package executor.service.service.executor;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.step.StepExecution;
import executor.service.service.step.StepExecutionType;
import org.openqa.selenium.WebDriver;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ScenarioExecutorService
        implements ScenarioExecutor {

    @Override
    public void execute(
            final Scenario scenario,
            final WebDriver webDriver) {
        webDriver.get(scenario.getSite());
        executeStep(new LinkedBlockingQueue<>(scenario.getSteps()), webDriver);
        webDriver.quit();
    }

    private void executeStep(
            final Queue<Step> queue,
            final WebDriver webDriver) {
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            getStepExecution(step).step(webDriver, step);
        }
    }

    private StepExecution getStepExecution(
            final Step step) {
        return StepExecutionType
                .fromString(step.getAction())
                .getStepExecution();
    }
}
