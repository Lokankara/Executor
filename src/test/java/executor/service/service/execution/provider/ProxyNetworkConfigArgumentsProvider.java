package executor.service.service.execution.provider;

import executor.service.model.ProxyNetworkConfig;
import executor.service.service.plugin.FileSourcesReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static executor.service.model.Constants.NETWORK_FILENAME;

public class ProxyNetworkConfigArgumentsProvider
        implements ArgumentsProvider {


    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext extensionContext) {

        return Stream.of(Arguments.of(new FileSourcesReader().getAllFromFile(
                NETWORK_FILENAME,
                ProxyNetworkConfig.class)));
    }
}
