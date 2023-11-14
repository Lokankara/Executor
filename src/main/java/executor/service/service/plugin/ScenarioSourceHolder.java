package executor.service.service.plugin;

import executor.service.model.Scenario;

import java.util.Queue;

public class ScenarioSourceHolder {
    private final Queue<Scenario> scenarioQueue;

    private ScenarioSourceHolder(Queue<Scenario> scenarios) {
        this.scenarioQueue = scenarios;
    }

    private static class Holder {
        private static ScenarioSourceHolder instance;
    }

    public static ScenarioSourceHolder getInstance() {
        return Holder.instance;
    }

    public static ScenarioSourceHolder getInstance(
            final Queue<Scenario> scenarios) {
        if (Holder.instance == null) {
            Holder.instance = new ScenarioSourceHolder(scenarios);
        }
        return Holder.instance;
    }

    public Queue<Scenario> getScenarioQueue() {
        return scenarioQueue;
    }
}
