package com.heroes.models;

import com.heroes.interfaces.Gold;
import com.heroes.interfaces.Leather;

import java.util.Scanner;

public abstract class Hero extends Character implements Gold, Leather {
    private int gold;
    private int leather;
    // Constructors
    public Hero(String name, int stamina, int strength, int health) {
        super(name, stamina, strength, health);
        this.gold = 0;
        this.leather = 0;
    }
    // Getters
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
    public void battleRoyal(Battleground battleground) {
        System.out.println(String.format("Welcome to %s. Be prepared to fight %s monsters!", battleground.getName(), battleground.getMonsters().size()));
        Character enemy;
        boolean alive = true;
        int kills = 0;
        while (alive && battleground.getMonsters().size() > 0) {
            int health = this.getHealth();
            enemy = battleground.getMonsters().get(0);
            if (this.fights(enemy)) {
                if (enemy instanceof Dragon) {
                    System.out.println(String.format("%s is dead! You gain %s gold and %s leather.", enemy.getName(), ((Dragon) enemy).getGold(), ((Dragon) enemy).getLeather()));
                    this.setGold(this.getGold()+((Dragon) enemy).getGold());
                    this.setLeather(this.getLeather()+ ((Dragon) enemy).getLeather());
                }
                else if (enemy instanceof Orc) {
                    System.out.println(String.format("%s is dead! You gain %s gold.", enemy.getName(), ((Orc) enemy).getGold()));
                    this.setGold(this.getGold()+ ((Orc) enemy).getGold());
                }
                else {
                    System.out.println(String.format("%s is dead! You gain %s leather.", enemy.getName(), ((Wolf) enemy).getLeather()));
                    this.setLeather(this.getLeather()+ ((Wolf) enemy).getLeather());
                }
                battleground.removeMonster(enemy);
                kills++;
                System.out.println(String.format("%s sets a campfire and heals himself. Now he can continue his adventure.", this.getName()));
                this.setHealth(health);
            }
            else {
                alive = false;
            }
        }
        if (!alive) {
            System.out.println(String.format("You died after killing %s monsters!", kills));
        }
        else {
            System.out.println(String.format("Congratulations, you killed all the %s monsters!", kills));
        }
        System.out.println(String.format("You had %s gold and %s leather", this.getGold(), this.getLeather()));
    }
    public void adventure(Battleground battleground) {
        System.out.println(String.format("Welcome to %s. Be prepared to fight %s monsters!", battleground.getName(), battleground.getMonsters().size()));
        Character enemy = null;
        boolean alive = true;
        int kills = 0;
        battleground.showMap();
        while (alive && battleground.getMonsters().size() > 0) {
            int health = this.getHealth();
            this.move(battleground);
            enemy = battleground.isMonster(this.getPosX(), this.getPosY());
            if (enemy != null) {
                if (this.fights(enemy)) {
                    if (enemy instanceof Dragon) {
                        System.out.println(String.format("%s is dead! You gain %s gold and %s leather.", enemy.getName(), ((Dragon) enemy).getGold(), ((Dragon) enemy).getLeather()));
                        this.setGold(this.getGold()+((Dragon) enemy).getGold());
                        this.setLeather(this.getLeather()+ ((Dragon) enemy).getLeather());
                    }
                    else if (enemy instanceof Orc) {
                        System.out.println(String.format("%s is dead! You gain %s gold.", enemy.getName(), ((Orc) enemy).getGold()));
                        this.setGold(this.getGold()+ ((Orc) enemy).getGold());
                    }
                    else {
                        System.out.println(String.format("%s is dead! You gain %s leather.", enemy.getName(), ((Wolf) enemy).getLeather()));
                        this.setLeather(this.getLeather()+ ((Wolf) enemy).getLeather());
                    }
                    battleground.removeMonster(enemy);
                    kills++;
                    battleground.showMap();
                    System.out.println(String.format("%s sets a campfire and heals himself. Now he can continue his adventure.", this.getName()));
                    this.setHealth(health);
                }
                else {
                    alive = false;
                }
            }
        }
        if (!alive) {
            System.out.println(String.format("You died after killing %s monsters!", kills));
        }
        else {
            System.out.println(String.format("Congratulations, you killed all the %s monsters!", kills));
        }
        System.out.println(String.format("You had %s gold and %s leather", this.getGold(), this.getLeather()));
    }
    private void move(Battleground battleground){
        Scanner input = new Scanner(System.in);
        String direction = "x";
        while (!"lrdu".contains(direction)){
            System.out.printf("Where do you want to move (Left, Right, Up, Down)?: ");
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
                    if (this.getPosY() == 14) {
                        System.out.println("You can't move up. Please choose again.");
                    }
                    else {
                        this.setPosY(this.getPosY()+1);
                        battleground.showMap();
                    }
                    break;
                case "d":
                    if (this.getPosY() == 0) {
                        System.out.println("You can't move down. Please choose again.");
                    }
                    else {
                        this.setPosY(this.getPosY()-1);
                        battleground.showMap();
                    }
                    break;
                default:
                    System.out.println("This is not a valid direction. Please choose again.");
                    break;
            }
        }
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", Gold: %s, Leather: %s", this.gold, this.leather);
    }
}
