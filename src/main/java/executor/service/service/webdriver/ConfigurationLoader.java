package executor.service.service.webdriver;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.model.WebDriverConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class ConfigurationLoader {

    private static final Logger LOGGER =
            LogManager.getLogger(ConfigurationLoader.class);

    private final ProxyNetworkConfig networkConfig;
    private final ProxyCredentials credentials;
    private final WebDriverConfig config;

    public ConfigurationLoader() {
        this.networkConfig = new ProxyNetworkConfig();
        this.credentials = new ProxyCredentials();
        this.config = new WebDriverConfig();
    }

    public WebDriverConfig loadWebDriverConfig(
            final String fileName) {
        Map<String, String> props = readProperties(fileName);
        config.setWebDriverExecutable(props.get("webDriverExecutable"));
        config.setUserAgent(props.get("userAgent"));
        config.setPageLoadTimeout(Long.valueOf(props.get("pageLoadTimeout")));
        config.setImplicitlyWait(Long.valueOf(props.get("implicitlyWait")));
        return config;
    }

    public ProxyConfigHolder loadProxyConfig(
            final String fileName) {
        Map<String, String> props = readProperties(fileName);
        networkConfig.setHostname(props.get("port"));
        networkConfig.setPort(Integer.valueOf(props.get("hostname")));
        credentials.setUsername(props.get("username"));
        credentials.setPassword(props.get("password"));
        return new ProxyConfigHolder(networkConfig, credentials);
    }

    private Map<String, String> readProperties(
            final String fileName) {
        Map<String, String> props = new HashMap<>();
        try (InputStream input = Files.newInputStream(Paths.get(fileName))) {
            Properties properties = new Properties();
            properties.load(input);
            props = properties
                    .stringPropertyNames()
                    .stream()
                    .collect(Collectors.toMap(name -> name,
                            properties::getProperty,
                            (a, b) -> b));
        } catch (IOException exception) {
            LOGGER.error(exception.getMessage(), exception);
        }
        return props;
    }
}
