package exceptions;

public class LimitReachedException extends RuntimeException {
    private final int limit;

    // constructor
    public LimitReachedException(int limit) {
        super("Participant could not be added. Maximum limit of participants reached.");
        this.limit = limit;
    }

    // getters
    public int getLimit() {
        return this.limit;
    }
}
