import exceptions.*;
import models.Competition;
import models.Judoka;
import models.Runner;

import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("Competition Simulator 2000");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // create a Runner competition
        Competition<Runner> runnerCompetition = new Competition(3);
        // create Runners
        Runner bruce = new Runner("Bruce", "Willis", LocalDate.parse("01/01/1980", formatter));
        Runner johnny = new Runner("Johnny", "Depp", LocalDate.parse("02/02/1980", formatter));
        Runner will = new Runner("Will", "Smith", LocalDate.parse("03/03/1980", formatter));
        Runner brad = new Runner("Brad", "Pitt", LocalDate.parse("04/04/1980", formatter));

        // try to remove bruce
        System.out.println("Try to remove Bruce but...");
        try {
            runnerCompetition.removeParticipant(bruce);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add bruce
        try {
            runnerCompetition.addParticipant(bruce);
        }
        catch (StateCompetitionException exception) {
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
            runnerCompetition.removeParticipant(bruce);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add bruce
        try {
            runnerCompetition.addParticipant(bruce);
        }
        catch (StateCompetitionException exception) {
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
            runnerCompetition.addParticipant(johnny);
        }
        catch (StateCompetitionException exception) {
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
            runnerCompetition.addParticipant(will);
        }
        catch (StateCompetitionException exception) {
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
            runnerCompetition.addParticipant(will);
        }
        catch (StateCompetitionException exception) {
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
            runnerCompetition.addParticipant(brad);
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }
        catch (DuplicatedException exception) {
            System.out.println(exception.getMessage());
        }
        catch (LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("---------------------------------------");
        System.out.println(runnerCompetition.toString());
        System.out.println("Is the competition finished?: " + runnerCompetition.isFinished());

        // try to get the winner
        System.out.println("Try to get the winner but...");
        try {
            System.out.println("The winner is: " + runnerCompetition.getWinner().toString());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("---------------------------------------");

        // try to begin the competition
        try {
            runnerCompetition.begin();
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // check if the competition is already finished
        System.out.println("Is the competition finished?: " + runnerCompetition.isFinished());

        // try to get the winner
        try {
            System.out.println("The winner is: " + runnerCompetition.getWinner().toString());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to remove will
        System.out.println("Try to remove Will but...");
        try {
            runnerCompetition.removeParticipant(will);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to begin the competition again
        System.out.println("Try to begin the competition again but...");
        try {
            runnerCompetition.begin();
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("---------------------------------------");

        // create a Judoka competition
        Competition<Judoka> judokaCompetition = new Competition(3);
        Judoka seb = new Judoka("Sebastien", "Ruiz", LocalDate.parse("04/04/1990", formatter));
        Judoka rufat = new Judoka("Rufat", "Babayev", LocalDate.parse("06/06/1990", formatter));
        Judoka thabit = new Judoka("Thabit", "Hamror", LocalDate.parse("07/07/1993", formatter));

        // try to add seb
        try {
            judokaCompetition.addParticipant(seb);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add rufat
        try {
            judokaCompetition.addParticipant(rufat);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add james
        try {
            judokaCompetition.addParticipant(thabit);
        }
        catch (NotRegisteredException exception) {
            System.out.println(exception.getMessage());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("---------------------------------------");

        // try to begin the competition
        try {
            judokaCompetition.begin();
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // check if the competition is already finished
        System.out.println("Is the competition finished?: " + judokaCompetition.isFinished());

        // try to get the winner
        try {
            System.out.println("The winner is: " + judokaCompetition.getWinner().toString());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
