package executor.service.service.plugin;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProxySourcesClientService
        implements ProxySourcesClient {

    private static final String proxyConfigPath = "proxy.properties";
    private ProxyConfigHolder cachedProxyConfig;

    @Override
    public ProxyConfigHolder getProxy() {
        if (cachedProxyConfig != null) {
            return cachedProxyConfig;
        }

        try (InputStream is = getClass().getResourceAsStream(proxyConfigPath)) {
            if (is == null) {
                throw new FileNotFoundException("File not found on classpath: " + proxyConfigPath);
            }

            Properties prop = new Properties();
            prop.load(is);

            Integer port = Integer.valueOf(prop.getProperty("port"));
            String hostname = prop.getProperty("hostname");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            cachedProxyConfig = new ProxyConfigHolder(
                    new ProxyNetworkConfig(hostname, port),
                    new ProxyCredentials(username, password));
            return cachedProxyConfig;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}