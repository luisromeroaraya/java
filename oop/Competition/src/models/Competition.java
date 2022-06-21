package models;

import exceptions.*;
import interfaces.ICompetition;

import java.util.*;

public class Competition implements ICompetition {
    private final int limitParticipants;
    private final Map<Participant, Integer> participants;

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

    public Map<Participant, Integer> getParticipants() {
        return this.participants;
    }

    public boolean isFinished() { return this.isFinished; }

    // setters
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    // methods
    @Override
    public void begin() throws AlreadyFinishedException {
        if (this.isFinished()) {
            throw new AlreadyFinishedException();
        }
        // create points for each participant and add them to the participant list
        System.out.println("The competition has started");
        this.getParticipants().forEach((participant, points) -> {
            this.getParticipants().put(participant, participant.perform());
        });
        // sort participants in descending order by points
        LinkedHashMap<Participant, Integer> sorted = new LinkedHashMap<>();
        this.getParticipants()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));
        // show participants
        System.out.println("Results:");
        for (Map.Entry<Participant, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue() + " points.");
        }
        this.setFinished(true);
    }

    @Override
    public void addParticipant(Participant participant) throws AlreadyFinishedException, DuplicatedException, LimitReachedException {
        if(this.isFinished()) {
            throw new AlreadyFinishedException();
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
    public void removeParticipant(Participant participant) throws NotRegisteredException, AlreadyFinishedException {
        if (this.isFinished()) {
            throw new AlreadyFinishedException();
        }
        if (!this.getParticipants().containsKey(participant)) {
            throw new NotRegisteredException();
        }
        this.participants.remove(participant);
        System.out.println(participant.toString() + " has been removed from the competition.");
    }

    @Override
    public Participant getWinner() throws NotFinishedException {
        if (!this.isFinished()) {
            throw new NotFinishedException();
        }
        Participant winner = null;
        for (Map.Entry<Participant, Integer> entry : this.getParticipants().entrySet()) {
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
        for (Map.Entry<Participant, Integer> entry : this.getParticipants().entrySet()) {
            participants = participants + entry.getKey().toString() + "\n";
        }
        return "Limit of Participants:" + this.getLimitParticipants() + "\nParticipants:\n" + participants;
    }
}