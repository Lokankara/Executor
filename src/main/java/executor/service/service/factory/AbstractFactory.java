package executor.service.service.factory;

public interface AbstractFactory {
    <T> T create(Class<T> clazz);
}
