package com.heroes.models;

import java.util.*;

public class Battleground {
    String name;
    private ArrayList<Character> heroes;
    private ArrayList<Character> monsters;
    // Constructors
    public Battleground(String name) {
        this.name = name;
        this.heroes = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }
    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<Character> getHeroes() {
        return heroes;
    }
    public ArrayList<Character> getMonsters() {
        return monsters;
    }
    // Setters
    // Methods
    public void showCharacters() {
        System.out.println("Heroes:");
        for (Character hero : heroes) {
            System.out.println(hero.toString());
        }
        System.out.println("Monsters:");
        for (Character monster : monsters) {
            System.out.println(monster.toString());
        }
    }
    public void addCharacter(Character character) {
        if (character instanceof Hero) {
            this.getHeroes().add(character);
        }
        else {
            this.getMonsters().add(character);
        }
    }
    public void removeMonster(Character monster) {
        this.getMonsters().remove(monster);
    }
    public void createCharacter(String name, String race) {
        int stamina = this.getRandom();
        int strength = this.getRandom();
        int health = this.getHealth(stamina);
        Character character = null;
        switch (race.toLowerCase()) {
            case "dragon":
                character = new Dragon(name, stamina, strength, health);
                break;
            case "dwarf":
                character = new Dwarf(name, stamina, strength, health);
                break;
            case "human":
                character = new Human(name, stamina, strength, health);
                break;
            case "orc":
                character = new Orc(name, stamina, strength, health);
                break;
            case "wolf":
                character = new Wolf(name, stamina, strength, health);
                break;
        }
        this.addCharacter(character);
    }
    public void inputCharacter(){
        String name, race;
        Scanner input = new Scanner(System.in);
        System.out.printf("Please enter the name of the character: ");
        name = input.nextLine();
        System.out.printf("Please choose the race of the character (Dragon, Dwarf, Human, Orc, Wolf): ");
        race = input.nextLine();
        this.createCharacter(name, race);
    }
    public static int rollDice(int max) {
        Random dice = new Random();
        return dice.nextInt(1,max+1);
    }
    private int getRandom(){
        int random = 0;
        ArrayList<Integer> dices = new ArrayList<>();
        for (int i=0; i <4; i++){
            dices.add(this.rollDice(6));
        }
        Collections.sort(dices, Collections.reverseOrder());
        for (int i=0; i <3; i++){
            random = random + dices.get(i);
        }
        return random;
    }
    private int getHealth(int stamina) {
        int health = 0;
        if (stamina < 5) {
            health = stamina - 1;
        }
        else if (stamina < 10) {
            health = stamina;
        }
        else if (stamina < 15) {
            health = stamina + 1;
        }
        else {
            health = stamina + 2;
        }
        return health;
    }
    public void showMap() {
        ArrayList<Character> monsters = this.getMonsters();
        for (int posX = 0; posX < 15; posX++) {
            for (int posY = 0; posY < 15; posY++) {
                for (Character monster : monsters) {
                    if (posX < monsters.size() && posY < monsters.size()) {
                        if (monster.getPosX() == posX && monster.getPosY() == posY){
                            if (monster instanceof Hero) {
                                System.out.printf(" H ");
                            }
                            else if (monster instanceof Dragon) {
                                System.out.printf(" D ");
                            }
                            else if (monster instanceof Orc) {
                                System.out.printf(" O ");
                            }
                            else {
                                System.out.printf(" W ");
                            }
                        }
                    } else {
                        System.out.printf(" X ");
                    }
                }
            }
            System.out.println("");
        }
    }
}
