package executor.service.service.execution.provider;

import executor.service.model.Scenario;
import executor.service.service.plugin.FileSourcesReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static executor.service.model.Constants.SCENARIO_FILENAME;
import static java.util.Arrays.asList;

public class ScenariosArgumentsProvider
        implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(
            final ExtensionContext context) {
        return Stream.of(Arguments.of(asList(new FileSourcesReader().readFile(
                SCENARIO_FILENAME,
                Scenario[].class))));
    }
}
