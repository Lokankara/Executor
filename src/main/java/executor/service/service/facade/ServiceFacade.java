package executor.service.service.facade;

import executor.service.model.Scenario;

public class ServiceFacade {
    private final ScenarioService scenarioService;

    public ServiceFacade(ScenarioService scenarioService) {
        this.scenarioService = scenarioService;
    }

    public void executeScenario(Scenario scenario) {
        scenarioService.executeScenario(scenario);
    }
}
