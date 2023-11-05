package executor.service.service.execution.provider;

import executor.service.model.ProxyNetworkConfig;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static executor.service.service.plugin.FileSourcesReader.readFile;
import static java.util.Arrays.asList;

public class ProxyNetworkConfigArgumentsProvider
        implements ArgumentsProvider {

    private static final String filename = "json/ProxyNetwork.json";

    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext extensionContext) {

        return Stream.of(Arguments.of(
                asList(readFile(filename, ProxyNetworkConfig[].class))));
    }
}
