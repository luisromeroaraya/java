package oop.model;

import java.util.HashMap;

public class Knight {
    private String name;
    private String lastName;
    private HashMap<String, Horse> horses; // we chose HashMap to avoid the repetition of horses

    // constructors
    public Knight(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.horses = new HashMap<>();
    }
    public Knight(String name, String lastName, HashMap<String, Horse> horses) {
        this.name = name;
        this.lastName = lastName;
        this.horses = horses;
    }
    // getters
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public HashMap<String, Horse> getHorses() {
        return horses;
    }
    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // methods
    public void addHorse(Horse horse) {
        this.horses.put(horse.getName(), horse);
    }
}
