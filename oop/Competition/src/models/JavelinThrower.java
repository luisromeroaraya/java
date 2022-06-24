package models;

import anottations.NotParticipant;
import enumerations.Localisation;

import java.time.LocalDate;
import java.util.Random;

public class JavelinThrower extends Participant {
    private int power;
    private int experience;

    // constructor
    public JavelinThrower(String first_name, String last_name, LocalDate birth_date, int power, Localisation localisation) {
        super(first_name, last_name, birth_date, localisation);
        setPower(power);
        setExperience(experience);
    }

    // getters

    public int getPower() {
        return this.power;
    }

    public int getExperience() {
        return this.experience;
    }

    // setters
    public void setPower(int power) {
        if (power < 30 || power > 50) {
            throw new IllegalArgumentException("Power must be a number between 30 and 50");
        }
        this.power = power;
    }

    public void setExperience(int experience) {
        if (experience < 0 || experience > 20) {
            throw new IllegalArgumentException("Experience must be a number between 0 and 20");
        }
        this.experience = experience;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        return (this.getPower()+ this.getExperience())*random.nextInt(70, 90+1)/100;
    }
}
