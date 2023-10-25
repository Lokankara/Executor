package executor.service.service.execution;

import executor.service.model.Scenario;
import org.openqa.selenium.WebDriver;

public interface Executor {
    void execute(Scenario scenario, WebDriver webDriver);
}
