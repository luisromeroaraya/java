package exceptions;

public class DuplicatedException extends IllegalArgumentException {
    public DuplicatedException() {
        super("Participant is already registered and could not be added.");
    }
}
