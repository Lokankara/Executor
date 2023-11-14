package executor.service.service.factory;

import executor.service.exception.ConstructorException;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InterfaceMap {

    private final Map<Class<?>, Object> services = new HashMap<>();

    public InterfaceMap(String rootPackage) {
        Reflections reflections = new Reflections(rootPackage);
        Set<Class<?>> allInterfaces = reflections
                .getSubTypesOf(Object.class)
                .stream()
                .filter(Class::isInterface)
                .collect(Collectors.toSet());

        for (Class<?> interfaces : allInterfaces) {
            try {
                Object service =
                        interfaces.getDeclaredConstructor().newInstance();
                services.put(interfaces, service);
            } catch (Exception e) {
                throw new ConstructorException(
                        "Failed to create service: %s".formatted(interfaces),
                        e);
            }
        }
    }

    public <T> T getService(Class<T> serviceClass) {
        if (services.containsKey(serviceClass)) {
            return serviceClass.cast(services.get(serviceClass));
        } else {
            throw new ConstructorException(
                    "No service found for class: %s".formatted(serviceClass));
        }
    }
}
