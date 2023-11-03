package executor.service.service.facade;

import executor.service.model.Scenario;

public class ServiceFacade {
    private final ScenarioService scenarioService;

    public ServiceFacade(
            final ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    public void executeScenario(
            final Scenario scenario) {
        scenarioService.executeScenario(scenario);
    }
}
