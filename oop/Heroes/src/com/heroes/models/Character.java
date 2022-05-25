package com.heroes.models;

public abstract class Character {
    private String name;
    private int stamina;
    private int strength;
    private int health;
    private int posX;
    private int posY;
    // Constructors
    public Character(String name, int stamina, int strength, int health) {
        this.name = name;
        this.stamina = stamina;
        this.strength = strength;
        this.health = health;
        this.posX = Battleground.rollDice(14);
        this.posY = Battleground.rollDice(14);
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getRace() {
        if (this instanceof Dragon) {
            return "Dragon";
        }
        else if (this instanceof Dwarf) {
            return "Dwarf";
        }
        else if (this instanceof Human) {
            return "Human";
        }
        else if (this instanceof Orc) {
            return "Orc";
        }
        else if (this instanceof Wolf) {
            return "Wolf";
        }
        else {
            return "N/A";
        }
    }
    public int getStamina() {
        return stamina;
    }
    public int getStrength() {
        return strength;
    }
    public int getHealth() {
        return health;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    // Setters
    public void setHealth(int health) {
        this.health = health;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }

    // Methods
    public void attack(Character enemy) {
        int damage = getDamage(this.getStrength());
        System.out.println(String.format("%s (Health: %s) attacks %s (Health: %s) and does %s points of damage.", this.getName(), this.getHealth(), enemy.getName(), enemy.getHealth(), damage));
        enemy.setHealth(enemy.getHealth()-damage);
    }
    public boolean fights(Character enemy) {
        boolean turn = true;
        System.out.println(String.format("%s steps into %s and prepares to fight.", this.getName(), enemy.getName()));
        while (this.getHealth() > 0 && enemy.getHealth() > 0) {
            if (turn) {
                this.attack(enemy);
            }
            else {
                enemy.attack(this);
            }
            turn = !turn;
        }
        if (!turn) {
            System.out.println(String.format("%s (Health: %s) wins!", this.getName(), this.getHealth()));
            return true;
        }
        else {
            return false;
        }
    }
    public void adventure(Battleground battleground) {
    };
    private int getDamage(int strength) {
        int damage = Battleground.rollDice(4);
        if (strength < 5) {
            damage = damage - 1;
        }
        else if (strength < 10) {
            damage = damage + 0;
        }
        else if (strength < 15) {
            damage = damage + 1;
        }
        else {
            damage = damage + 2;
        }
        return damage;
    }
    @Override
    public String toString() {
        return String.format("Name: %s, Race: %s, Stamina: %s, Strength: %s, Health: %s", this.getName(), this.getRace(), this.getStamina(), this.getStrength(), this.getHealth());
    }
}
