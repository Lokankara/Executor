package executor.service.service.plugin;

import executor.service.exception.FileReadException;
import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static executor.service.model.Constants.PROXY_CONFIG_FILENAME;

public class ProxySourcesClientService
        implements ProxySourcesClient {
    private ProxyConfigHolder cachedProxyConfig;

    @Override
    public ProxyConfigHolder getProxy() {
        if (cachedProxyConfig != null) {
            return cachedProxyConfig;
        }

        try (InputStream inputStream = getClass()
                .getResourceAsStream(PROXY_CONFIG_FILENAME)) {
            if (inputStream == null) {
                throw new FileNotFoundException(
                        String.format("File not found on classpath: %s%n",
                                PROXY_CONFIG_FILENAME));
            }

            Properties prop = new Properties();
            prop.load(inputStream);

            Integer port = Integer.valueOf(prop.getProperty("port"));
            String hostname = prop.getProperty("hostname");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            cachedProxyConfig = new ProxyConfigHolder(
                    new ProxyNetworkConfig(hostname, port),
                    new ProxyCredentials(username, password));
            return cachedProxyConfig;
        } catch (IOException e) {
            throw new FileReadException(e.getMessage());
        }
    }
}