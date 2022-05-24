package oop.model;

import java.util.Random;

public class Horse {
    // private attributes that can't be accessed from the outside
    // public attributes can be accessed from anywhere
    // if I don't put private or public the attribute can be accessed only from classes in the same folder
    // protected allows you to access the attribute only by subclasses
    private String name;
    private int speedMin;
    private int speedMax;
    // constructors (methods called when we create a new object. you can set initial values if there are arguments)
    // you can have many constructors to allow different ways of creating a new object
    public Horse(String name, int speedMin, int speedMax) {
        System.out.println("New horse available.");
        this.name = name;
        this.speedMin = speedMin;
        this.speedMax = speedMax;
    }
    public Horse(String name) {
        System.out.println("New horse available.");
        this.name = name;
    }

    //#region getters and setters
    // getters (allow you to read the attributes from the outside
    public String getName() {
        return name;
    }
    public int getSpeedMin() {
        return speedMin;
    }
    public int getSpeedMax() {
        return speedMax;
    }
    // setters (allow you to change the attributes from the outside
    public void setName(String name) {
        this.name = name;
    }
    public void setSpeedMin(int speedMin) {
        this.speedMin = speedMin;
    }
    public void setSpeedMax(int speedMax) {
        this.speedMax = speedMax;
    }
    //#endregion
    // methods
    public int run() {
        Random random = new Random();
        return random.nextInt(speedMin, speedMax);
    }
    public int run(int bonus) {
        Random random = new Random();
        return random.nextInt(speedMin, speedMax) + bonus;
    }
    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", speedMin=" + speedMin +
                ", speedMax=" + speedMax +
                '}';
    }
    public static void neigh() {
        System.out.println("Brrrrr");
    }
}
