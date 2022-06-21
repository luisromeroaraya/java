package models;

import java.time.LocalDate;
import java.util.Random;

public class Participant {
    private final String first_name;
    private final String last_name;
    private final LocalDate birth_date;

    // constructor
    public Participant(String first_name, String last_name, LocalDate birth_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
    }

    // getters

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    // methods

    public int perform() {
        Random random = new Random();
        int points = random.nextInt(1, 100+1);
        return points;
    }

    @Override
    public String toString() {
        return this.getFirst_name() + " " + this.getLast_name() + " (" + this.getBirth_date() + ")";
    }
}
