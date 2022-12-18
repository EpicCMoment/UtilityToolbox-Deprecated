package kozmikoda.utilitytoolbox.passwordcase;

public class InvalidServiceException extends RuntimeException{
    InvalidServiceException(String serviceName) {
        super("Service \"" + serviceName + "\" doesn't exist.");
    }
}
