package com.Animalerie.Models;
import java.time.LocalDate;

public class Cat extends Animal {
    private String character;
    private boolean paws;
    private boolean longHair;
    // constructors
    public Cat(String name, int weight, int height, Sex sex, int age, LocalDate date, String character, boolean paws, boolean longHair) {
        super(name, weight, height, sex, age, date);
        this.character = character;
        this.paws = paws;
        this.longHair = longHair;
        if (age == 1 ) {
            this.setHumanAge(15);
        }
        else if (age == 2) {
            this.setHumanAge(25);
        }
        else {
            this.setHumanAge(25+((age-2)*4));
        }
        this.setDeath(25); // 25 -> 100/25 = 4 -> 1 in 4
        // this.setDeath(0.5); // 0.5 -> 100/0.5 = 200 -> 1 in 200
    }
    // getters
    public String getCharacter() {
        return character;
    }
    public String hasPaws() {
        if (paws) {
            return "Yes";
        }
        else {
            return "No";
        }
    }
    public String hasLongHair() {
        if (longHair) {
            return "Yes";
        }
        else {
            return "No";
        }
    }
    // methods
    @Override
    public void cry() {
        System.out.println("Meow");
    }
    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %s, Height: %s, Sex: %s, Age: %s, Human Age: %s, Date of Arrival: %s, Character: %s, Paws: %s, Long hair: %s.", this.getName(), this.getWeight(), this.getHeight(), this.getSex(), this.getAge(), this.getHumanAge(), this.getDate(), this.getCharacter(), this.hasPaws(), this.hasLongHair());
    }
}
