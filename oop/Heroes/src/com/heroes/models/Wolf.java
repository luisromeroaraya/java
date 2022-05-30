package com.heroes.models;

import com.heroes.interfaces.ILeather;

public class Wolf extends Monster implements ILeather {
    private int leather;

    // Constructors
    public Wolf(String name, int stamina, int strength, int health, int posX, int posY) {
        super(name, stamina, strength, health, posX, posY);
        this.leather = Battleground.rollDice(4);
    }

    // Getters
    @Override
    public int getLeather() {
        return leather;
    }

    // Setters
    @Override
    public void setLeather(int leather) {
        this.leather = this.leather + leather;
    }

    // Methods
    @Override
    public String toString() {
        return super.toString() + String.format(", Leather: %s", this.leather);
    }
}
