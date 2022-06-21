package interfaces;

import exceptions.*;
import models.Participant;

public interface ICompetition {
    void begin() throws AlreadyFinishedException;
    void addParticipant(Participant participant) throws AlreadyFinishedException, DuplicatedException, LimitReachedException;
    void removeParticipant(Participant participant) throws NotRegisteredException, AlreadyFinishedException;
    Participant getWinner() throws NotFinishedException;
}