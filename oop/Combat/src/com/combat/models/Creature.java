package com.combat.models;

public class Creature {
    private String name;
    private int strength;
    private int armor;
    private int speed;
    private int health;

    // constructor

    public Creature() {
    }

    public Creature(String name, int strength, int armor, int speed) {
        this.name = name;
        this.strength = strength;
        this.armor = armor;
        this.speed = speed;
        this.health = 42 - (strength + armor + speed);
    }
    // getters
    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }
    public int getArmor() {
        return armor;
    }
    public int getSpeed() {
        return speed;
    }
    public int getHealth() {
        return health;
    }
    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    // methods
    @Override
    public String toString() {
        return String.format("Name: %s, Strength: %s, Armor: %s, Speed: %s, Health: %s", this.getName(), this.getStrength(), this.getArmor(), this.getSpeed(), this.getHealth());
    }
}
