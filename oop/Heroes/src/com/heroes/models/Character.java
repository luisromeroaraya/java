package com.heroes.models;

import java.util.Scanner;

public abstract class Character {
    private String name;
    private int stamina;
    private int strength;
    private int health;
    private int posX;
    private int posY;

    // Constructors
    public Character(String name, int stamina, int strength, int health, int posX, int posY) {
        this.name = name;
        this.stamina = stamina;
        this.strength = strength;
        this.health = health;
        this.posX = posX;
        this.posY = posY;
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
    public void attacks(Character enemy) {
        int damage = getDamage(this.getStrength());
        System.out.println(String.format("%s (Health: %s) attacks %s (Health: %s) and does %s points of damage.", this.getName(), this.getHealth(), enemy.getName(), enemy.getHealth(), damage));
        enemy.setHealth(enemy.getHealth()-damage);
    }
    public boolean fights(Character enemy) {
        boolean turn = true;
        System.out.println(String.format("%s steps into %s and prepares to fight.", this.getName(), enemy.getName()));
        while (this.getHealth() > 0 && enemy.getHealth() > 0) {
            if (turn) {
                this.attacks(enemy);
            }
            else {
                enemy.attacks(this);
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
    public void battleRoyal(Battleground battleground) {
    };
    public void adventure(Battleground battleground) {
    }
    public void move(Battleground battleground){
        Scanner input = new Scanner(System.in);
        String direction = "x";
        while (!"lrdu".contains(direction)){
            System.out.printf("Position: (%s,%s). Where do you want to move (Left, Right, Up, Down)?: ", this.getPosX(), this.getPosY());
            direction = String.valueOf(input.nextLine().toLowerCase().charAt(0));
            switch (direction) {
                case "l":
                    if (this.getPosX() == 0) {
                        System.out.println("You can't move left. Please choose again.");
                    }
                    else {
                        this.setPosX(this.getPosX()-1);
                        battleground.showMap();
                    }
                    break;
                case "r":
                    if (this.getPosX() == 14) {
                        System.out.println("You can't move right. Please choose again.");
                    }
                    else {
                        this.setPosX(this.getPosX()+1);
                        battleground.showMap();
                    }
                    break;
                case "u":
                    if (this.getPosY() == 0) {
                        System.out.println("You can't move up. Please choose again.");
                    }
                    else {
                        this.setPosY(this.getPosY()-1);
                        battleground.showMap();
                    }
                    break;
                case "d":
                    if (this.getPosY() == 14) {
                        System.out.println("You can't move down. Please choose again.");
                    }
                    else {
                        this.setPosY(this.getPosY()+1);
                        battleground.showMap();
                    }
                    break;
                default:
                    System.out.println("This is not a valid direction. Please choose again.");
                    break;
            }
        }
    }
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
