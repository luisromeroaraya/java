package com.heroes.models;

import com.heroes.interfaces.Gold;

public class Orc extends Monster implements Gold {
    private int gold;

    // Constructors
    public Orc(String name, int stamina, int strength, int health, int posX, int posY) {
        super(name, stamina, strength, health, posX, posY);
        this.gold = Battleground.rollDice(6);
    }

    // Getters
    @Override
    public int getStrength() {
        return super.getStrength() + 1;
    }
    @Override
    public int getGold() {
        return gold;
    }
    // Setters
    @Override
    public void setGold(int gold) {
        this.gold = this.gold + gold;
    }
    // Methods
    @Override
    public String toString() {
        return super.toString() + String.format(", Gold: %s", this.gold);
    }
}
