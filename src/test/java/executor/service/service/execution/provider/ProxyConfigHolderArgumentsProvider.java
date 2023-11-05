package executor.service.service.execution.provider;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static executor.service.model.Constants.CREDENTIALS_FILENAME;
import static executor.service.model.Constants.NETWORK_FILENAME;
import static executor.service.service.plugin.FileSourcesReader.readFile;

public class ProxyConfigHolderArgumentsProvider
        implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(
            final ExtensionContext extensionContext) {
        ProxyCredentials[] credentials =
                readFile(CREDENTIALS_FILENAME, ProxyCredentials[].class);
        ProxyNetworkConfig[] configs =
                readFile(NETWORK_FILENAME, ProxyNetworkConfig[].class);

        return Stream.of(Arguments.of(IntStream
                .range(0, configs.length)
                .mapToObj(i -> new ProxyConfigHolder(configs[i], credentials[i]))
                .collect(Collectors.toList())));
    }
}
