package executor.service.exception;

public class ConstructorException
        extends RuntimeException {
    public ConstructorException(
            final String message,
            final Throwable e) {
        super(message, e);
    }

    public ConstructorException(
            final String message) {
        super(message);
    }

    public ConstructorException(Throwable e) {
        super(e);
    }
}
