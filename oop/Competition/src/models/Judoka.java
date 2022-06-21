package models;

import java.time.LocalDate;
import java.util.Random;

public class Judoka extends Participant {
    private final int power;

    // constructor
    public Judoka(String first_name, String last_name, LocalDate birth_date) {
        super(first_name, last_name, birth_date);
        Random random = new Random();
        this.power = random.nextInt(40,80+1);
    }

    // getters
    public int getPower() {
        return this.power;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        int points = this.getPower()+random.nextInt(-20, 20+1);
        return points;
    }
}
