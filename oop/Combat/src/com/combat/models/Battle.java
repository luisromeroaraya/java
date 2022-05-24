package com.combat.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle {
    private ArrayList<Trainer> trainers;

    // constructors
    public Battle() {
        this.trainers = new ArrayList<>();
    }
    // getters
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }
    // methods
    public void addTrainer(Trainer trainer) {
        this.trainers.add(trainer);
    }
    public void fight(Trainer trainer1, Trainer trainer2) {
        Trainer winner = null;
        while (winner == null) {
            choose(trainer1);
            choose(trainer2);
        }
        this.wins(winner);
    }
    public void choose(Trainer trainer) {
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.printf(trainer.getName() + ", choose your next move (Attack/Defend/Dodge/Change): ");
        choice = input.nextLine().toLowerCase();
        switch(choice) {
            case "attack":
                trainer.attack();
                break;
            case "defend":
                trainer.defend();
                break;
            case "dodge":
                trainer.dodge();
                break;
            case "change":
                trainer.changeCreature();
                break;
        }
    }
    public void wins(Trainer trainer) {
        System.out.println(trainer + " wins!");
    }

    @Override
    public String toString() {
        return "Battle{" +
                "trainers=" + trainers +
                '}';
    }
}
