package interfaces;

import models.Participant;

import java.util.Set;

public interface ICompetition<P extends Participant> {
    void begin();
    void addParticipant(P participant);
    void removeParticipant(P participant);
    Set<P> getWinner();
    boolean isFinished();
    int getLimitParticipants();
}