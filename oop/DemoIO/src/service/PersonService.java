package service;

import models.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final File file;

    // constructors
    public PersonService(String filepath) {
        this.file = new File(filepath); // comma separated values .csv
    }

    // methods
    public void write(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person can't be null.");
        }
        try (PrintStream writer = new PrintStream(new FileOutputStream(this.file, true))){
            writer.printf("%s,%s,%3$td-%3$tm-%3$tY\n", person.getFirst_name(), person.getLast_name(), person.getBirth_date()); // John Smith 01/01/1980
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public List<Person> read() throws Exception {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            reader.readLine(); // to skip the first line
            String line = null;
            while ((line = reader.readLine()) != null) {
                Person person = convert(line);
                persons.add(person);
            }
            return persons;
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        throw new Exception("Error reading file.");
    }

    public Person convert(String line) throws Exception {
        String[] data = line.split(",");
        if (data.length != 3) {
            throw new Exception("Conversion error, data in wrong format.");
        }
        String first_name = data[0];
        String last_name = data[1];
        System.out.println(data[2]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 01-01-1980
        LocalDate date = LocalDate.parse(data[2], formatter);
        return new Person(first_name, last_name, date);
    }
}
