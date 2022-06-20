package exceptions;

public class NotRegisteredException extends Exception {
    public NotRegisteredException() {
        super("The participant is not registered.");
    }
}
