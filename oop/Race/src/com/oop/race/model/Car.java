package com.oop.race.model;

import java.util.Random;

public class Car {
    private String manufacturer;
    private String model;
    private int speedMin;
    private int speedMax;
    // constructor
    public Car(String manufacturer, String model, int speedMin, int speedMax) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.speedMin = speedMin;
        this.speedMax = speedMax;
    }
    // getters
    public String getManufacturer() {
        return manufacturer;
    }
    public String getModel() {
        return model;
    }
    public int getSpeedMin() {
        return speedMin;
    }
    public int getSpeedMax() {
        return speedMax;
    }

    // methods
    public int getSpeed() {
        Random random = new Random();
        return random.nextInt(this.getSpeedMin(), this.getSpeedMax());
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getManufacturer(), this.getModel());
    }
}
