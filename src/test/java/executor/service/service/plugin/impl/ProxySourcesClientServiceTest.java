package executor.service.service.plugin.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import executor.service.model.ProxyConfigHolder;
import executor.service.model.ProxyCredentials;
import executor.service.model.ProxyNetworkConfig;
import executor.service.service.plugin.ProxySourcesClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.InputStream;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProxySourcesClientServiceTest {
    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private InputStream mockInputStream;

    private ProxySourcesClient proxySourcesClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        proxySourcesClient = new ProxySourcesClientService();
    }

    @Test
    @DisplayName("Given a ProxySourcesClient instance, when calling getProxy, it should return a valid ProxyConfigHolder")
    void testGetProxy() {
        ProxyConfigHolder expectedProxyConfigHolder = createMockProxyConfigHolder();
        ProxySourcesClientService mockService = Mockito.mock(ProxySourcesClientService.class);
        when(mockService.getProxy()).thenReturn(expectedProxyConfigHolder);
        ProxyConfigHolder actualProxyConfigHolder = mockService.getProxy();
        assertEquals(expectedProxyConfigHolder, actualProxyConfigHolder);
    }

    private ProxyConfigHolder createMockProxyConfigHolder() {
        ProxyNetworkConfig networkConfig = new ProxyNetworkConfig("host", 8080);
        ProxyCredentials credentials = new ProxyCredentials("username", "password");
        return new ProxyConfigHolder(networkConfig, credentials);
    }
}