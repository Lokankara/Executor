package executor.service.exception;

public class InvalidImplementationCountException
        extends RuntimeException {
    public InvalidImplementationCountException(
            final String message) {
        super(message);
    }
}
