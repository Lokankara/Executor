package executor.service.service.proxy;

import executor.service.model.ProxyConfigHolder;

public class FeignProxySourcesClient
        implements ProxySourcesClient {

    private ProxySourcesClient proxyService;

    public FeignProxySourcesClient(ProxySourcesClientService proxyService) {
        this.proxyService = proxyService;
    }

    @Override
    public ProxyConfigHolder getProxy() {
        if (proxyService == null) {
            proxyService = new ProxySourcesClientService();
        }
        return proxyService.getProxy();
    }
}
