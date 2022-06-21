package exceptions;

public class StateCompetitionException extends IllegalStateException {
    private final boolean realState;
    private final boolean expectedState;

    // constructor
    public StateCompetitionException(boolean realState, boolean expectedState) {
        super("The competition is "+ (realState ? "" : "not ") + "finished. To do this action " +
                "it must be " + (expectedState ? "" : "not ") + "finished." );
        this.realState = realState;
        this.expectedState = expectedState;
    }

    // getters

    public boolean isRealState() {
        return this.realState;
    }

    public boolean isExpectedState() {
        return this.expectedState;
    }
}
