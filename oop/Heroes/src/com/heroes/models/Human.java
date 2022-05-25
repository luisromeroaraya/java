package com.heroes.models;

import com.heroes.interfaces.Gold;
import com.heroes.interfaces.Leather;

public class Human extends Hero {
    // Constructors
    public Human(String name, int stamina, int strength, int health) {
        super(name, stamina, strength, health);
    }
    // Getters
    @Override
    public int getStamina() {
        return super.getStamina() + 1;
    }
    @Override
    public int getStrength() {
        return super.getStrength() + 1;
    }
}
