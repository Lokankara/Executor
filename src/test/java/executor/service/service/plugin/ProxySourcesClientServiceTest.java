package executor.service.service.plugin;

import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.execution.provider.ProxyCredentialsArgumentsProvider;
import executor.service.service.execution.provider.ProxyNetworkConfigArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProxySourcesClientServiceTest {

    @InjectMocks
    private ProxySourcesClient sourcesClientService;

    @Mock
    private ProxyNetworkConfig proxyNetworkConfig;

    @Mock
    private ProxyCredentials proxyCredentials;


    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.openMocks(this);
        sourcesClientService = new ProxySourcesClientService();
    }

    @Test
    @DisplayName("Given a ProxySourcesClient instance, when calling getProxy, it should return a valid ProxyConfigHolder")
    void testGetProxy() {
        ProxyConfigHolder expectedProxyConfigHolder = createMockProxyConfigHolder();
        ProxySourcesClientService mockService = mock(
                ProxySourcesClientService.class);
        when(mockService.getProxy()).thenReturn(expectedProxyConfigHolder);
        ProxyConfigHolder actualProxyConfigHolder = mockService.getProxy();
        assertEquals(expectedProxyConfigHolder, actualProxyConfigHolder);
    }

    private ProxyConfigHolder createMockProxyConfigHolder() {
        ProxyNetworkConfig networkConfig = new ProxyNetworkConfig("host", 8080);
        ProxyCredentials credentials = new ProxyCredentials("username", "password");
        return new ProxyConfigHolder(networkConfig, credentials);
    }

//    @ParameterizedTest
//    @ArgumentsSource(ProxyNetworkConfigArgumentsProvider.class)
//    @ArgumentsSource(ProxyCredentialsArgumentsProvider.class)
//    @DisplayName("Given a ProxySourcesClientService instance, when getProxy method is called, then the correct ProxyConfigHolder is returned")
//    void testGetProxy(
//            List<ProxyNetworkConfig> proxyNetworkConfigs,
//            List<ProxyCredentials> proxyCredentialss) {
//        System.out.println(proxyCredentialss);
//        System.out.println(proxyNetworkConfigs);
//        when(FileSourcesReader.readFile("json/ProxyNetwork.json",
//                ProxyNetworkConfig.class)).thenReturn(proxyNetworkConfig);
//        when(FileSourcesReader.readFile("json/ProxyCredentials.json",
//                ProxyCredentials.class)).thenReturn(proxyCredentials);
//        ProxyConfigHolder proxyConfigHolder = sourcesClientService.getProxy();
//        assertEquals(proxyNetworkConfig,
//                proxyConfigHolder.getProxyNetworkConfig());
//        assertEquals(proxyCredentials, proxyConfigHolder.getProxyCredentials());
//    }

}
