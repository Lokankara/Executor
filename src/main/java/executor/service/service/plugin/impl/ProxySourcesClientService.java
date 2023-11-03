package executor.service.service.plugin.impl;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.plugin.ProxySourcesClient;

import static executor.service.service.plugin.FileSourcesReader.readFile;

public class ProxySourcesClientService
        implements ProxySourcesClient {

    @Override
    public ProxyConfigHolder getProxy() {
        ProxyConfigHolder proxyConfigHolder = new ProxyConfigHolder();
        proxyConfigHolder.setProxyCredentials(
                readFile("ProxyCredentials.json", ProxyCredentials.class));
        proxyConfigHolder.setProxyNetworkConfig(
                readFile("ProxyNetwork.json", ProxyNetworkConfig.class));
        return proxyConfigHolder;
    }
}
