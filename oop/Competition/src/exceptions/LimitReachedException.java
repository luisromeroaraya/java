package exceptions;

public class LimitReachedException extends Exception {
    public LimitReachedException() {
        super("Participant could not be added. Maximum limit of participants reached.");
    }
}
