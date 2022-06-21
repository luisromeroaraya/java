package models;

import exceptions.*;
import interfaces.ICompetition;

import java.util.*;

public class Competition<P extends Participant> implements ICompetition<P> {
    private final int limitParticipants;
    private final Map<P, Integer> participants;

    private boolean isFinished;

    // constructor
    public Competition(int limitParticipants) {
        this.limitParticipants = Math.abs(limitParticipants);
        this.participants = new HashMap<>();
        this.isFinished = false;
    }

    // getters
    public int getLimitParticipants() {
        return this.limitParticipants;
    }

    public Map<P, Integer> getParticipants() {
        return this.participants;
    }

    public boolean isFinished() { return this.isFinished; }

    // setters
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    // methods
    @Override
    public void begin() {
        if (this.isFinished()) {
            throw new StateCompetitionException(isFinished(), false);
        }
        // create points for each participant and add them to the participant list
        System.out.println("The competition has started");
        this.getParticipants().forEach((participant, points) -> {
            this.getParticipants().put(participant, participant.perform());
        });
        // sort participants in descending order by points
        LinkedHashMap<P, Integer> sorted = new LinkedHashMap<>();
        this.getParticipants()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
        // show participants
        System.out.println("Results:");
        for (Map.Entry<P, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue() + " points.");
        }
        this.setFinished(true);
    }

    @Override
    public void addParticipant(P participant) {
        if (this.isFinished()) {
            throw new StateCompetitionException(isFinished(), false);
        }
        if(this.getParticipants().containsKey(participant)){
            throw new DuplicatedException();
        }
        if(this.getParticipants().size() >= this.getLimitParticipants()) {
            throw new LimitReachedException(this.getLimitParticipants());
        }
        this.getParticipants().put(participant, null);
        System.out.println(participant.toString() + " has been added to the competition.");
    }

    @Override
    public void removeParticipant(P participant) {
        if (this.isFinished()) {
            throw new StateCompetitionException(isFinished(), false);
        }
        if (!this.getParticipants().containsKey(participant)) {
            throw new NotRegisteredException();
        }
        this.participants.remove(participant);
        System.out.println(participant.toString() + " has been removed from the competition.");
    }

    @Override
    public P getWinner() {
        if (!this.isFinished()) {
            throw new StateCompetitionException(isFinished(), true);
        }
        P winner = null;
        for (Map.Entry<P, Integer> entry : this.getParticipants().entrySet()) {
            if (winner == null) {
                winner = entry.getKey();
            }
            else if (entry.getValue() >= this.getParticipants().get(winner)) {
                winner = entry.getKey();
            }
        }
        return winner;
    }

    @Override
    public String toString() {
        String participants = "";
        for (Map.Entry<P, Integer> entry : this.getParticipants().entrySet()) {
            participants = participants + entry.getKey().toString() + "\n";
        }
        return "Limit of Participants:" + this.getLimitParticipants() + "\nParticipants:\n" + participants;
    }
}