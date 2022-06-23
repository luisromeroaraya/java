package exceptions;

public class LocalisationException extends IllegalArgumentException {
    public LocalisationException() {
        super("Participant doesn't have access to this type of competition.");
    }
}
