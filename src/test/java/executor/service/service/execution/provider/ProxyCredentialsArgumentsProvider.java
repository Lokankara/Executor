package executor.service.service.execution.provider;

import executor.service.model.ProxyCredentials;
import executor.service.model.Step;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static executor.service.service.plugin.FileSourcesReader.readFile;
import static java.util.Arrays.asList;

public class ProxyCredentialsArgumentsProvider
        implements ArgumentsProvider {
    private static final String filename = "json/ProxyCredentials.json";

    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext extensionContext) {

        return Stream.of(Arguments.of(
                asList(readFile(filename, ProxyCredentials[].class))));
    }
}
