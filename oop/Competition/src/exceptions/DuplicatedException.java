package exceptions;

public class DuplicatedException extends Exception {
    public DuplicatedException() {
        super("Participant is already registered and could not be added.");
    }
}
