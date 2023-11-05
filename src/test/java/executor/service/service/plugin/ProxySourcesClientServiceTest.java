package executor.service.service.plugin;

import executor.service.model.ProxyConfigHolder;
import executor.service.service.execution.provider.ProxyConfigHolderArgumentsProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProxySourcesClientServiceTest {

    @Mock
    private ProxySourcesClient service;

    private AutoCloseable closeable;

    @BeforeEach
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void cleanUp() throws Exception {
        closeable.close();
    }

    @ParameterizedTest
    @ArgumentsSource(ProxyConfigHolderArgumentsProvider.class)
    @DisplayName("Given a ProxySourcesClient instance, when calling getProxy, it should return a valid ProxyConfigHolder")
    void testGetProxies(List<ProxyConfigHolder> proxyConfigHolders) {
        for (ProxyConfigHolder proxyConfigHolder : proxyConfigHolders) {
            when(service.getProxy()).thenReturn(proxyConfigHolder);
            ProxyConfigHolder actual = service.getProxy();
            assertEquals(proxyConfigHolder, actual);
        }
    }

    @ParameterizedTest
    @ArgumentsSource(ProxyConfigHolderArgumentsProvider.class)
    @DisplayName("Given a ProxyConfigHolderArgumentsProvider list, when getProxy method is called, then the correct ProxyConfigHolder is returned")
    void testGetRealProxy(List<ProxyConfigHolder> proxyConfigHolders) {
        ProxySourcesClientService service = new ProxySourcesClientService();
        assertEquals(proxyConfigHolders.get(0), service.getProxy());
    }
}
