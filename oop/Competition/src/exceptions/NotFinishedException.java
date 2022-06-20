package exceptions;

public class NotFinishedException extends Exception {
    public NotFinishedException() {
        super("Cant' show winner. The competition is not finished yet.");
    }
}
