package exceptions;

public class NotFinishedException extends IllegalStateException {
    public NotFinishedException() {
        super("Cant' show winner. The competition is not finished yet.");
    }
}
