package executor.service.service.execution.provider;

import executor.service.model.ProxyCredentials;
import executor.service.service.plugin.FileSourcesReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static executor.service.model.Constants.CREDENTIALS_FILENAME;
import static java.util.Arrays.asList;

public class ProxyCredentialsArgumentsProvider
        implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(
            ExtensionContext extensionContext) {
        return Stream.of(Arguments.of(asList(new FileSourcesReader().readFile(
                CREDENTIALS_FILENAME,
                ProxyCredentials[].class))));
    }
}
