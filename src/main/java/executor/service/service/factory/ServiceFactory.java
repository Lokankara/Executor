package executor.service.service.factory;

import executor.service.exception.ConstructorException;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory<T> {
    private final Map<Class<T>, T> services = new HashMap<>();

    public T getService(Class<T> serviceClass) {
        if (!services.containsKey(serviceClass)) {
            try {
                T service = serviceClass.getDeclaredConstructor().newInstance();
                services.put(serviceClass, service);
            } catch (Exception e) {
                throw new ConstructorException(
                        String.format("Failed to create service: %s%n",
                                serviceClass), e);
            }
        }
        return services.get(serviceClass);
    }
}
