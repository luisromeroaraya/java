package models;

import enumerations.Localisation;

import java.time.LocalDate;
import java.util.Random;

public class Runner extends Participant {
    private int speed;
    private int weight;

    // constructor
    public Runner(String first_name, String last_name, LocalDate birth_date, int speed, int weight, Localisation localisation) {
        super(first_name, last_name, birth_date, localisation);
        setSpeed(speed);
        setWeight(weight);
    }

    // getters
    public int getSpeed() {
        return this.speed;
    }

    public int getWeight() {
        return this.weight;
    }

    // setters
    public void setSpeed(int speed) {
        if (speed < 8 || speed > 13) {
            throw new IllegalArgumentException("Speed must be a number between 8 and 13");
        }
        this.speed = speed;
    }

    public void setWeight(int weight) {
        if (weight < 60 || weight > 200) {
            throw new IllegalArgumentException("Weight must be a number between 60 and 200");
        }
        this.weight = weight;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        return random.nextInt(110, 130+1)* this.getSpeed()/ this.getWeight();
    }
}
