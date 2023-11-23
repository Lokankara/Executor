package executor.service.service.execution.provider;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.plugin.FileSourcesReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static executor.service.model.Constants.CREDENTIALS_FILENAME;
import static executor.service.model.Constants.NETWORK_FILENAME;

public class ProxyConfigHolderArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(
            final ExtensionContext extensionContext) {
        FileSourcesReader reader = new FileSourcesReader();
        ProxyCredentials[] credentials =
                reader.readFile(CREDENTIALS_FILENAME, ProxyCredentials[].class);
        ProxyNetworkConfig[] configs =
                reader.readFile(NETWORK_FILENAME, ProxyNetworkConfig[].class);

        return Stream.of(Arguments.of(
                new LinkedList<>(IntStream
                .range(0, configs.length)
                .mapToObj(i -> new ProxyConfigHolder(configs[i], credentials[i]))
                .toList())));
    }
}
