import models.Person;
import service.PersonService;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // FileWriter true if I want to keep what is already written, false if I want to erase the file before writing
//        try (FileWriter fw = new FileWriter("resources/new_file.txt", false)){ // we put the FileWriter inside the try argument, so it can autoclose
//            // ask the user its name and age and save it in a file
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Please enter your name: ");
//            String name = sc.nextLine();
//            System.out.print("Please enter your age: ");
//            int age = sc.nextInt();
//
//            // write the file
//            fw.write(String.format("%s(%s)", name, age));
//            // fw.append(name).append("(").append(String.valueOf(age)).append(")");
//        } catch (IOException exception) {
//            System.out.println(exception.getMessage());
//        } catch (InputMismatchException exception){
//            System.out.println("Input not valid.");
//        }

        /////////////////////////////////////

        PersonService service = new PersonService("resources/list_names.csv");
        service.write(new Person("John", "Smith", LocalDate.now()));
        service.write(new Person("John", "Doe", LocalDate.now()));

        try {
            List<Person> list = service.read();
            for (Person person : list) {
                System.out.println(person);
            }
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}