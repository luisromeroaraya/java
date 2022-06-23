package models;

import enumerations.Localisation;

import java.time.LocalDate;

public abstract class Participant {
    private Localisation localisation;
    private final String first_name;
    private final String last_name;
    private final LocalDate birth_date;
    private int totalGain;

    // constructor
    public Participant(String first_name, String last_name, LocalDate birth_date, Localisation localisation) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.totalGain = 0;
        this.localisation = localisation;
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

    public int getTotalGain() { return this.totalGain; }

    public Localisation getLocalisation() { return this.localisation; }

    // setters
    public void setTotalGain(int totalGain) { this.totalGain = this.totalGain + totalGain; }
    public void setLocalisation(Localisation localisation) { this.localisation = localisation; }

    // methods
    abstract int perform();

    @Override
    public String toString() {
        return this.getFirst_name() + " " + this.getLast_name() + " (" + this.getBirth_date() + ", Total gain = " + this.getTotalGain() + " euros)";
    }
}
