package com.heroes.models;

public class Dwarf extends Hero {
    public Dwarf(String name, int stamina, int strength, int health) {
        super(name, stamina, strength, health);
    }
    // Getters
    @Override
    public int getStamina() {
        return super.getStamina() + 2;
    }
}
