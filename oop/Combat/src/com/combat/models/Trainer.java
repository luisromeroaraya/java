package com.combat.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {
    private String name;
    private Creature selectedCreature;
    private ArrayList<Creature> creatures;
    // constructor
    public Trainer(String name) {
        this.name = name;
        this.creatures = new ArrayList<>();
    }
    // getters
    public String getName() {
        return name;
    }
    public ArrayList<Creature> getCreatures() {
        return creatures;
    }
    public Creature getSelectedCreature() {
        return selectedCreature;
    }
    // setters
    public void setSelectedCreature(Creature selectedCreature) {
        this.selectedCreature = selectedCreature;
    }
    // methods
    public void attack() {
        System.out.println(this.getSelectedCreature().getName() + " attacks!");
    }
    public void defend() {
        System.out.println(this.getSelectedCreature().getName() + " defends!");
    }
    public void dodge() {
        System.out.println(this.getSelectedCreature().getName() + " dodges!");
    }
    public void addCreature(Creature creature) {
        this.getCreatures().add(creature);
        setSelectedCreature(creature);
    }
    public void changeCreature() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.printf("Choose a creature (");
        for (int i=0; i<this.getCreatures().size(); i++) {
            System.out.printf((i+1) + ". " + this.getCreatures().get(i).getName() + " ");
        }
        System.out.printf("): ");
        choice = Integer.parseInt(input.nextLine());
        setSelectedCreature(this.getCreatures().get(choice-1));
        System.out.println(this.getSelectedCreature().getName() + " has been selected.");
    }

    @Override
    public String toString() {
        String string = String.format("Trainer: %s. Creatures:", this.getName());
        for (Creature creature : this.getCreatures()) {
            if (this.getCreatures().get(this.getCreatures().size()-1) == creature) {
                string  = string + String.format(" %s.", creature.getName());
            }
            else {
                string  = string + String.format(" %s,", creature.getName());
            }
        }
        string = string + String.format(" Selected Creature: %s", this.getSelectedCreature().getName());
        return string;
    }
}
