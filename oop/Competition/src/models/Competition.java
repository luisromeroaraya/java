package models;

import exceptions.*;

import java.util.*;

public class Competition {
    int limitParticipants;
    Map<Participant, Integer> participants;
    private Participant participant;

    // constructor
    public Competition(int limiteParticipant) {
        this.limitParticipants = limiteParticipant;
        this.participants = new HashMap<Participant, Integer>();
    }

    // getters

    public int getLimitParticipants() {
        return this.limitParticipants;
    }

    public Map<Participant, Integer> getParticipants() {
        return this.participants;
    }

    // methods

    public void begin() throws AlreadyFinishedException {
        if (isFinished()) {
            throw new AlreadyFinishedException();
        }
        else {
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
        }
    }

    public void addParticipant(Participant participant) throws AlreadyFinishedException, DuplicatedException, LimitReachedException {
        if(this.isFinished()) {
            throw new AlreadyFinishedException();
        }
        else if(this.getParticipants().containsKey(participant)){
            throw new DuplicatedException();
        }
        else if(this.getParticipants().size() >= this.getLimitParticipants()) {
            throw new LimitReachedException();
        }
        else {
            this.getParticipants().put(participant, 0);
            System.out.println(participant.toString() + " has been added to the competition.");
        }

    }

    public void removeParticipant(Participant participant) throws NotRegisteredException, AlreadyFinishedException {
        if (!this.getParticipants().containsKey(participant)) {
            throw new NotRegisteredException();
        }
        else if (isFinished()) {
            throw new AlreadyFinishedException();
        }
        else {
            this.participants.remove(participant);
            System.out.println(participant.toString() + " has been removed from the competition.");
        }
    }

    public boolean isFinished() {
        boolean isFinished = true;
        if (this.getParticipants().size() == 0) {
            isFinished = false;
        }
        for (Map.Entry<Participant, Integer> entry : this.getParticipants().entrySet()) {
            if (entry.getValue() == 0) {
                isFinished = false;
            }
        }
        return isFinished;
    }

    public Participant getWinner() throws NotFinishedException {
        if (!this.isFinished()) {
            throw new NotFinishedException();
        }
        else {
            Participant winner = null;
            for (Map.Entry<Participant, Integer> entry : this.getParticipants().entrySet()) {
                if (winner == null) {
                    winner = entry.getKey();
                }
                else if (entry.getValue() < this.getParticipants().get(winner)) {
                    winner = entry.getKey();
                }
            }
            return winner;
        }
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