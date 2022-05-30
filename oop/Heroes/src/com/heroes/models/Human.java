package com.heroes.models;

import com.heroes.interfaces.Gold;
import com.heroes.interfaces.Leather;

public class Human extends Hero {

    // Constructors
    public Human(String name, int stamina, int strength, int health, int posX, int posY) {
        super(name, stamina, strength, health, posX, posY);
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
