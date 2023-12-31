package executor.service.service.execution.provider;

import executor.service.model.Step;
import executor.service.service.plugin.FileSourcesReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class ActionsArgumentsProvider implements ArgumentsProvider {
    private static final String filename = "json/ClickActions.json";

    @Override
    public Stream<? extends Arguments> provideArguments(
            final ExtensionContext context) {
        return Stream.of(Arguments.of(asList(
                new FileSourcesReader().readFile(filename, Step[].class))));
    }
}
