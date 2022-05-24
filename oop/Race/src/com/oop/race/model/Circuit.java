package com.oop.race.model;

public class Circuit {
    private String name;
    private int distance;
    // constructor
    public Circuit(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    // getters
    public String getName() {
        return name;
    }
    public int getDistance() {
        return distance;
    }
    // methods

    @Override
    public String toString() {
        return String.format("%s (%skm per lap).", this.getName(), this.getDistance());
    }
}
