package executor.service.service.plugin;

import executor.service.model.Scenario;

import java.util.Queue;

public interface ScenarioSourceListener {

    void execute();

    Queue<Scenario> getScenarioQueue();
}
