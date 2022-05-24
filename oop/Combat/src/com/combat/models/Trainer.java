package com.combat.models;

import java.util.ArrayList;

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
    // methods
    public void attack() {
        System.out.println(this.selectedCreature.getName() + " attacks!");
    }
    public void defend() {
        System.out.println(this.selectedCreature.getName() + " defends!");
    }
    public void dodge() {
        System.out.println(this.selectedCreature.getName() + " dodges!");
    }
    public void addCreature(Creature creature) {
        this.creatures.add(creature);
        this.selectedCreature = creature;
    }
    public void changeCreature() {
        System.out.printf("Choose a creature (");
        for (int i=0; i<this.getCreatures().size(); i++) {
            System.out.printf((i+1) + ". " + this.getCreatures().get(i).getName() + " ");
        }
        System.out.printf("): ");
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", selectedCreature=" + selectedCreature +
                ", creatures=" + creatures +
                '}';
    }
}
