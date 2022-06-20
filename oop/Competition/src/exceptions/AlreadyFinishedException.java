package exceptions;

public class AlreadyFinishedException extends Exception {
    public AlreadyFinishedException() {
        super("The competition is already finished.");
    }
}
