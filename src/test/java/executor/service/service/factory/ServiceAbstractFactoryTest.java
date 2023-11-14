package executor.service.service.factory;

import executor.service.service.executor.ScenarioExecutorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class ServiceAbstractFactoryTest {

    @Test
    void testGetService() {
        ServiceFactory<ScenarioExecutorService> serviceFactory = new ServiceFactory<>();
        ScenarioExecutorService factoryService =
                serviceFactory.getService(ScenarioExecutorService.class);
        assertNotNull(factoryService,
                "ScenarioExecutorService should not be null");
        ScenarioExecutorService executorService =
                serviceFactory.getService(ScenarioExecutorService.class);
        assertSame(factoryService, executorService,
                "Should return the same ScenarioExecutorService instance");
    }
}
