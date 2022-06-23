import enumerations.Localisation;
import exceptions.*;
import models.Competition;
import models.JavelinThrower;
import models.Judoka;
import models.Runner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Competition Simulator 2000");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // create a Runner competition
        Competition<Runner> runnerCompetition = new Competition<>(3, 100);
        // create Runners
        Runner bruce = new Runner("Bruce", "Willis", LocalDate.parse("01/01/1980", formatter), 9, 80, Localisation.REGIONAL);
        Runner johnny = new Runner("Johnny", "Depp", LocalDate.parse("02/02/1980", formatter), 10, 70, Localisation.REGIONAL);
        Runner will = new Runner("Will", "Smith", LocalDate.parse("03/03/1980", formatter), 11, 90, Localisation.REGIONAL);
        Runner brad = new Runner("Brad", "Pitt", LocalDate.parse("04/04/1980", formatter), 12, 80, Localisation.INTERNATIONAL);

        // try to remove bruce
        System.out.println("Try to remove Bruce but...");
        try {
            runnerCompetition.removeParticipant(bruce);
        }
        catch (NotRegisteredException | StateCompetitionException exception) {
            System.out.println(exception.getMessage());
            // exception.printStackTrace();
        }

        // try to add bruce
        try {
            runnerCompetition.addParticipant(bruce);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to remove bruce
        try {
            runnerCompetition.removeParticipant(bruce);
        }
        catch (NotRegisteredException | StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add bruce
        try {
            runnerCompetition.addParticipant(bruce);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add johnny
        try {
            runnerCompetition.addParticipant(johnny);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add will
        try {
            runnerCompetition.addParticipant(will);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add will again
        System.out.println("Try to add Will again but...");
        try {
            runnerCompetition.addParticipant(will);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add brad
        System.out.println("Try to add Brad but...");
        try {
            runnerCompetition.addParticipant(brad);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
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
        catch (NotRegisteredException | StateCompetitionException exception) {
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
        Competition<Judoka> judokaCompetition = new Competition<>(3, 200);
        Judoka seb = new Judoka("Sebastien", "Ruiz", LocalDate.parse("04/04/1990", formatter), 60, Localisation.REGIONAL);
        Judoka rufat = new Judoka("Rufat", "Babayev", LocalDate.parse("06/06/1990", formatter), 70, Localisation.REGIONAL);
        Judoka thabit = new Judoka("Thabit", "Hamror", LocalDate.parse("07/07/1993", formatter), 50, Localisation.REGIONAL);

        // try to add seb
        try {
            judokaCompetition.addParticipant(seb);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add rufat
        try {
            judokaCompetition.addParticipant(rufat);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
            System.out.println(exception.getMessage());
        }

        // try to add james
        try {
            judokaCompetition.addParticipant(thabit);
        }
        catch (StateCompetitionException | LocalisationException | DuplicatedException | LimitReachedException exception) {
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
            System.out.println("The winner(s) is(are): " + judokaCompetition.getWinner().toString());
        }
        catch (StateCompetitionException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("---------------------------------------");

        // create a JavelinThrower competition
        Competition<JavelinThrower> competitionJavelin = new Competition<>(Localisation.REGIONAL);
        System.out.println(competitionJavelin.getLocalisation());
        System.out.println(competitionJavelin.getPrize());
        System.out.println(competitionJavelin.getLimitParticipants());
        // create random JavelinThrower participants
        List<JavelinThrower> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<competitionJavelin.getLimitParticipants(); i++) {
            list.add(new JavelinThrower("Participant", String.valueOf(i+1), LocalDate.parse("01/01/1980", formatter), random.nextInt(30,50+1), Localisation.REGIONAL));
        }
        System.out.println(list);
        competitionJavelin.addParticipant(list);
        competitionJavelin.begin();
    }
}
