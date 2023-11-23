package executor.service.service.proxy;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.plugin.FileSourcesReader;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import static executor.service.model.Constants.CREDENTIALS_FILENAME;
import static executor.service.model.Constants.NETWORK_FILENAME;

public class ProxySourcesClientService
        implements ProxySourcesClient {
    private final Queue<ProxyConfigHolder> cache = new LinkedBlockingQueue<>();

    private final FileSourcesReader readFile;

    public ProxySourcesClientService() {
        this.readFile = new FileSourcesReader();
        init();
    }

    private void init() {
        Queue<ProxyCredentials> credentials = readFile.readAllFromFile(
                CREDENTIALS_FILENAME,
                ProxyCredentials.class);
        Queue<ProxyNetworkConfig> configs = readFile.readAllFromFile(
                NETWORK_FILENAME,
                ProxyNetworkConfig.class);
        if (credentials.size() != configs.size()) {
            throw new IllegalArgumentException(
                    "Mismatch between credentials and configs length");
        }
        for (int i = 0; i < configs.size(); i++) {
            cache.add(new ProxyConfigHolder(configs.poll(), credentials.poll()));
        }
    }

    @Override
    public ProxyConfigHolder getProxy() {
        if (cache.isEmpty()) {
            throw new IllegalStateException("No more proxies available");
        }
        return cache.poll();
    }
}
