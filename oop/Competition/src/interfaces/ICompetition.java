package interfaces;

import exceptions.*;
import models.Participant;

public interface ICompetition<P> {
    void begin();
    void addParticipant(P participant);
    void removeParticipant(P participant);
    P getWinner();
}