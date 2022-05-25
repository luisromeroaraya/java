package com.Animalerie.Models;
import java.time.LocalDate;

public class Dog extends Animal {
    private String race;
    private String collar;
    private boolean trained;
    // constructors
    public Dog(String name, int weight, int height, Sex sex, int age, LocalDate date, String race, String collar, boolean trained) {
        super(name, weight, height, sex, age, date);
        this.race = race;
        this.collar = collar;
        this.trained = trained;
        if (age == 1 ) {
            super.setHumanAge(15);
        }
        else if (age == 2) {
            super.setHumanAge(24);
        }
        else {
            super.setHumanAge(24+((age-2)*4));
        }
        this.setDeath(50); // 50 -> 100/50 = 2 -> 1 in 2
        // this.setDeath(1); // 1 -> 100/1 = 100 -> 1 in 100
    }
    // getters
    public String getRace() {
        return race;
    }
    public String getCollar() {
        return collar;
    }
    public String isTrained() {
        if (trained) {
            return "Yes";
        }
        else {
            return "No";
        }
    }
    // methods
    @Override
    public void cry() {
        System.out.println("Woof");
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", Race: %s, Collar Color: %s, Trained: %s.", this.getName(), this.getWeight(), this.getHeight(), this.getSex(), this.getAge(), this.getHumanAge(), this.getDate(), this.getRace(), this.getCollar(), this.isTrained());
    }
}
