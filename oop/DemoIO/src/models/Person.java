package models;

import java.time.LocalDate;

public class Person {
    private String first_name;
    private String last_name;
    private LocalDate birth_date;

    // constructors

    public Person(String first_name, String last_name, LocalDate birth_date) {
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

    // setters

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    public void setBirth_date(LocalDate birth_date) { this.birth_date = birth_date; }

    // methods

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
