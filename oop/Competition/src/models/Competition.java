package models;

import anottations.NotParticipant;
import enumerations.Localisation;
import exceptions.*;
import interfaces.ICompetition;

import java.util.*;

public class Competition<P extends Participant> implements ICompetition<P> {
    private final Localisation localisation;
    private final int limitParticipants;
    private final int prize;
    private final Map<P, Integer> participants;
    private boolean isFinished;

    // constructor
    public Competition(int limitParticipants, int prize) {
        this.localisation = null;
        this.limitParticipants = Math.abs(limitParticipants);
        this.prize = prize;
        this.participants = new HashMap<>();
        this.isFinished = false;
    }
    public Competition(Localisation localisation) {
        this.localisation = localisation;
        this.limitParticipants = localisation.getLimitParticipants();
        this.prize = localisation.getPrize();
        this.participants = new HashMap<>();
        this.isFinished = false;
    }

    // getters

    public Localisation getLocalisation() { return localisation; }
    @Override
    public int getLimitParticipants() {
        return this.limitParticipants;
    }
    public int getPrize() { return this.prize; }
    public Map<P, Integer> getParticipants() {
        return this.participants;
    }
    @Override
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
        Set<P> winners = this.getWinner();
        for (P winner : winners) {
            winner.setTotalGain(winner.getTotalGain() + this.prize/winners.size()); // adds prize money to the winner's totalGain
        }
        System.out.println("The winner(s) is(are): " + winners.toString());
    }

    @Override
    public void addParticipant(P participant) {
        if (this.isFinished()) {
            throw new StateCompetitionException(isFinished(), false);
        }
        if (participant.getClass().isAnnotationPresent(NotParticipant.class)) {
            throw new IllegalArgumentException("This participant can't participate.");
        }
        if(this.getLocalisation() != participant.getLocalisation()) {
            throw new LocalisationException();
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

    public void addParticipant(Collection<? extends P> participants) {
        for (P participant : participants) {
            addParticipant(participant);
        }
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
    public Set<P> getWinner() {
        if (!this.isFinished()) {
            throw new StateCompetitionException(isFinished(), true);
        }
        Set<P> winners = new HashSet<>();
        // search for the maximum score
        int maxScore = 0;
        for (Map.Entry<P, Integer> entry : this.getParticipants().entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
            }
        }
        // search for all the participants who got the maximum score
        for (Map.Entry<P, Integer> entry : this.getParticipants().entrySet()) {
            if (entry.getValue() == maxScore) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    public void transferParticipants(Competition<? super P> competition){
        competition.addParticipant(this.getParticipants().keySet() );
    }

    @Override
    public String toString() {
        StringBuilder participants = new StringBuilder();
        for (Map.Entry<P, Integer> entry : this.getParticipants().entrySet()) {
            participants.append(entry.getKey().toString()).append("\n");
        }
        return "Limit of Participants:" + this.getLimitParticipants() + "\nParticipants:\n" + participants;
    }
}