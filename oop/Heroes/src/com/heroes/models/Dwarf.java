package com.heroes.models;

public class Dwarf extends Hero {
    // Constructors
    public Dwarf(String name, int stamina, int strength, int health, int posX, int posY) {
        super(name, stamina, strength, health, posX, posY);
    }

    // Getters
    @Override
    public int getStamina() {
        return super.getStamina() + 2;
    }
}
