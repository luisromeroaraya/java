package com.oop.race.model;

import java.util.ArrayList;

public class Driver {
    private String name;
    private Car car;
    private ArrayList<Integer> times;
    // constructors
    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
        this.times = new ArrayList<>();
    }
    // getters
    public String getName() {
        return name;
    }
    public Car getCar() {
        return car;
    }

    public ArrayList<Integer> getTimes() {
        return times;
    }

    // methods
    public int getLapTime() {
        return this.getTimes().get(this.getTimes().size() - 1);
    }
    public int getTotalTime() {
        int total = 0;
        for (int time: this.getTimes()) {
            total = total + time;
        }
        return total;
    }
    public void makeLap(Circuit circuit) {
        int distance = circuit.getDistance();
        int speed = this.getCar().getSpeed();
        int time = 60*60*distance/speed;
        this.getTimes().add(time);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", this.getName(), this.getCar().toString());
    }
}
