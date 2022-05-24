package com.oop.race.model;

import java.util.ArrayList;
import java.util.Map;

import static com.oop.race.Main.timeFormat;

public class Race {
    private String name;
    private Circuit circuit;
    private int laps;
    private final ArrayList<Driver> drivers;

    public Race(String name, Circuit circuit, int laps) {
        this.name = name;
        this.circuit = circuit;
        this.laps = laps;
        this.drivers = new ArrayList<>();
    }
    // getters
    public String getName() {
        return name;
    }
    public Circuit getCircuit() {
        return circuit;
    }
    public int getLaps() {
        return laps;
    }
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    // methods
    public void addDriver(Driver driver) {
        this.getDrivers().add(driver);
    }
    public void showLap() {
        System.out.println("Times for this lap:");
        for (Driver driver : this.getDrivers()){
            System.out.println(driver.getName() + ", " + driver.getLapTime() + " seconds.");
        }
        System.out.println("");
    }
    private void makeLap() {
        for (Driver driver : this.getDrivers()) {
            driver.makeLap(this.getCircuit());
        }
        System.out.println("Cars made a new lap.");
        this.showLap();
    }
    public void makeRace() {
        System.out.println("Welcome to the \"" + this.getName() + "\"!");
        System.out.println("Circuit: " + this.getCircuit().toString());
        System.out.println("The race has started...");
        for (int i=0; i < this.getLaps(); i++) {
            this.makeLap();
        }
    }
    public Driver findWinner() {
        Driver winner = null;
        for (Driver driver : this.getDrivers()) {
            if (winner == null) {
                winner = driver;
            }
            else if (driver.getTotalTime() < winner.getTotalTime()) {
                winner = driver;
            }
        }
        return winner;
    }
}