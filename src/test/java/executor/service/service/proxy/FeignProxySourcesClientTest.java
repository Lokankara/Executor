package executor.service.service.proxy;

import executor.service.model.ProxyConfigHolder;
import executor.service.service.execution.provider.ProxyConfigHolderArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FeignProxySourcesClientTest {

    private ProxySourcesClientService proxyService;
    private FeignProxySourcesClient feignClient;
    private ProxyConfigHolder proxyConfigHolder;

    @BeforeEach
    public void setup() {
        proxyService = Mockito.mock(ProxySourcesClientService.class);
        feignClient = new FeignProxySourcesClient(proxyService);
        proxyConfigHolder = new ProxyConfigHolder();
    }

    @Test
    void testGetProxy() {
        when(proxyService.getProxy()).thenReturn(proxyConfigHolder);
        ProxyConfigHolder result = feignClient.getProxy();
        assertEquals(proxyConfigHolder, result);
    }

    @ParameterizedTest(name = "ConfigHolder: {0}")
    @ArgumentsSource(ProxyConfigHolderArgumentsProvider.class)
    void testGetProxies(Queue<ProxyConfigHolder> proxyConfigHolder) {
        ProxyConfigHolder poll = proxyConfigHolder.poll();
        when(proxyService.getProxy()).thenReturn(poll);
        ProxyConfigHolder result = feignClient.getProxy();
        assertEquals(poll, result);
    }
}
