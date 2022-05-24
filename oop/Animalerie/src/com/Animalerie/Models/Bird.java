package com.Animalerie.Models;
import java.time.LocalDate;

public class Bird extends Animal {
    private String color;
    private Size size;
    // constructors
    public Bird(String name, int weight, int height, Sex sex, int age, LocalDate date, String color, Size size) {
        super(name, weight, height, sex, age, date);
        this.color = color;
        this.size = size;
        this.setHumanAge(age*4);
        this.setDeath(33); // 33 -> 100/33 = 3 -> 1 in 3
        // this.setDeath(3); // 3 -> 100/3 = 33 -> 1 in 33
    }
    // getters
    public String getColor() {
        return color;
    }
    public Size getSize() {
        return size;
    }
    // methods
    @Override
    public void cry() {
        System.out.println("Tweet tweet");
    }
    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %skg, Height: %scm, Sex: %s, Age: %sy, Human Age: %sy, Date of Arrival: %s, Color: %s, Cage Size: %s.", this.getName(), this.getWeight(), this.getHeight(), this.getSex(), this.getAge(), this.getHumanAge(), this.getDate(), this.getColor(), this.getSize());
    }
}
