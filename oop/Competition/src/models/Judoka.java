package models;

import enumerations.Localisation;

import java.time.LocalDate;
import java.util.Random;

public class Judoka extends Participant {
    private int power;

    // constructor
    public Judoka(String first_name, String last_name, LocalDate birth_date, int power, Localisation localisation) {
        super(first_name, last_name, birth_date, localisation);
        setPower(power);
    }

    // getters
    public int getPower() {
        return this.power;
    }

    //setters
    public void setPower(int power) {
        if (power < 40 || power > 80) {
            throw new IllegalArgumentException("Power must be a number between 40 and 80");
        }
        this.power = power;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        return this.getPower()+random.nextInt(-20, 20+1);
    }
}
