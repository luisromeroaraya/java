import exceptions.*;
import models.Competition;
import models.Participant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Competition Simulator 2000");
        Competition competition = new Competition(3);
        Participant bruce = new Participant("Bruce", "Willis", LocalDate.parse("01/01/1980", formatter));
        Participant johnny = new Participant("Johnny", "Depp", LocalDate.parse("02/02/1980", formatter));
        Participant will = new Participant("Will", "Smith", LocalDate.parse("03/03/1980", formatter));
        Participant brad = new Participant("Brad", "Pitt", LocalDate.parse("04/04/1980", formatter));

        // try to remove bruce
        System.out.println("Try to remove Bruce but...");
        try {
            competition.removeParticipant(bruce);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add bruce
        try {
            competition.addParticipant(bruce);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to remove bruce
        try {
            competition.removeParticipant(bruce);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add bruce
        try {
            competition.addParticipant(bruce);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add johnny
        try {
            competition.addParticipant(johnny);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add will
        try {
            competition.addParticipant(will);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add will again
        System.out.println("Try to add Will again but...");
        try {
            competition.addParticipant(will);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add brad
        System.out.println("Try to add Brad but...");
        try {
            competition.addParticipant(brad);
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("---------------------------------------");
        System.out.println(competition.toString());
        System.out.println("Is the competition finished?: " + competition.isFinished());

        // try to get the winner
        System.out.println("Try to get the winner but...");
        try {
            System.out.println("The winner is: " + competition.getWinner().toString());
        }
        catch (NotFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("---------------------------------------");

        // try to begin the competition
        try {
            competition.begin();
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        // check if the competition is already finished
        System.out.println("Is the competition finished?: " + competition.isFinished());

        // try to get the winner
        try {
            System.out.println("The winner is: " + competition.getWinner().toString());
        }
        catch (NotFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to remove will
        System.out.println("Try to remove Will but...");
        try {
            competition.removeParticipant(will);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to begin the competition again
        System.out.println("Try to begin the competition again but...");
        try {
            competition.begin();
        }
        catch (AlreadyFinishedException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
