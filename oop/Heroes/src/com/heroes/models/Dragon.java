package com.heroes.models;

import com.heroes.interfaces.Gold;
import com.heroes.interfaces.Leather;

public class Dragon extends Monster implements Gold, Leather {
    private int gold;
    private int leather;

    // Constructors
    public Dragon(String name, int stamina, int strength, int health, int posX, int posY) {
        super(name, stamina, strength, health, posX, posY);
        this.gold = Battleground.rollDice(6);
        this.leather = Battleground.rollDice(4);
    }

    // Getters
    @Override
    public int getStamina() {
        return super.getStamina() + 1;
    }
    @Override
    public int getGold() {
        return gold;
    }
    @Override
    public int getLeather() {
        return leather;
    }

    // Setters
    @Override
    public void setGold(int gold) {
        this.gold = this.gold + gold;
    }
    @Override
    public void setLeather(int leather) {
        this.leather = this.leather + leather;
    }

    // Methods
    @Override
    public String toString() {
        return super.toString() + String.format(", Gold: %s, Leather, %s", this.gold, this.leather);
    }
}