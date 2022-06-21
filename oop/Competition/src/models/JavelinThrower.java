package models;

import java.time.LocalDate;
import java.util.Random;

public class JavelinThrower extends Participant {
    private final int power;
    private final int experience;

    // constructor
    public JavelinThrower(String first_name, String last_name, LocalDate birth_date) {
        super(first_name, last_name, birth_date);
        Random random = new Random();
        this.power = random.nextInt(30,50+1);
        this.experience = random.nextInt(0, 20+1);
    }

    // getters

    public int getPower() {
        return this.power;
    }

    public int getExperience() {
        return this.experience;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        int distance = (this.getPower()+this.getExperience())*random.nextInt(70, 90)/100;
        return distance;
    }
}
