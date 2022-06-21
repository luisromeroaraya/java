package exceptions;

public class AlreadyFinishedException extends IllegalStateException {
    public AlreadyFinishedException() {
        super("The competition is already finished.");
    }
}
