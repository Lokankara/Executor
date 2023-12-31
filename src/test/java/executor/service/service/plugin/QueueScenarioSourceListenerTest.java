package executor.service.service.plugin;

import executor.service.model.Scenario;
import executor.service.service.execution.provider.ScenariosArgumentsProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static executor.service.model.Constants.SCENARIO_FILENAME;

import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class QueueScenarioSourceListenerTest {


    @InjectMocks
    private QueueScenarioSourceListener queueScenarioSourceListener;

    @ParameterizedTest
    @ArgumentsSource(ScenariosArgumentsProvider.class)
    @DisplayName("Given a QueueScenarioSourceListener instance, when execute method is called, then the correct scenarios are added to the queue")
    void testExecute(List<Scenario> scenarios) {
        Queue<Scenario> scenarioQueue = queueScenarioSourceListener
                .execute(SCENARIO_FILENAME, Scenario.class);
        assertEquals(scenarios.size(), scenarioQueue.size());
    }
}
