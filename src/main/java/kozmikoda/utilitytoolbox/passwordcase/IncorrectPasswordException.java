package kozmikoda.utilitytoolbox.passwordcase;

public class IncorrectPasswordException extends RuntimeException{
    IncorrectPasswordException() {
        super("Password is incorrect.");
    }
}
