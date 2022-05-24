package com.Animalerie.Models;
import java.time.LocalDate;
import java.util.Random;

public class Animal {
    private String name;
    private int weight;
    private int height;
    private Sex sex;
    private int age;
    private int humanAge;
    private LocalDate date;
    private double death;
    // constructor
    public Animal(String name, int weight, int height, Sex sex, int age, LocalDate date) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.age = age;
        this.humanAge = age;
        this.date = date;
        this.death = 0;
    }
    // getters
    public String getName() {
        return name;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public Sex getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public int getHumanAge() {
        return humanAge;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getDeath() {
        return death; }
    // setters
    public void setDeath(double death) {
        this.death = death;
    }
    public void setHumanAge(int humanAge) {
        this.humanAge = humanAge;
    }
    // methods
    public String isAlive() {
        Random random = new Random();
        int temp = random.nextInt(1,100/(int)this.getDeath()+1);
        System.out.printf("Probability of death: %s%% (1 in %s). Random number = %s => ", this.getDeath(), 100/this.getDeath(), temp);
        if (temp == 1 ) {
            return "No";
        }
        else {
            return "Yes";
        }
    }
    public void cry() {
        System.out.println("...");
    }
    @Override
    public String toString() {
        return String.format("Name: %s, Weight: %skg, Height: %scm, Sex: %s, Age: %sy, Human Age: %sy, Date of Arrival: %s.", this.getName(), this.getWeight(), this.getHeight(), this.getSex(), this.getAge(), this.getHumanAge(), this.getDate());
    }
}
