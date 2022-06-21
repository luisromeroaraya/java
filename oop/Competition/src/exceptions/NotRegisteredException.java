package exceptions;

public class NotRegisteredException extends IllegalStateException {
    public NotRegisteredException() {
        super("The participant is not registered.");
    }
}
