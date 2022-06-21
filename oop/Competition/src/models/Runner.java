package models;

import java.time.LocalDate;
import java.util.Random;

public class Runner extends Participant {
    private final int speed;
    private final int weight;

    // constructor
    public Runner(String first_name, String last_name, LocalDate birth_date) {
        super(first_name, last_name, birth_date);
        Random random = new Random();
        this.speed = random.nextInt(8,13+1);
        this.weight = random.nextInt(60,200);
    }

    // getters
    public int getSpeed() {
        return this.speed;
    }

    public int getWeight() {
        return this.weight;
    }

    // methods
    @Override
    public int perform() {
        Random random = new Random();
        System.out.println(random.nextInt(110, 130+1));
        int seconds = random.nextInt(110, 130+1)*this.getSpeed()/this.getWeight();
        return seconds;
    }
}
