package com.Animalerie;
import com.Animalerie.Models.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Store store = new Store();
        // add animals automatically
        Cat tom = new Cat("Tom", 4, 30, Sex.MALE, 1, LocalDate.of(2019,01,21), "Energic", true, false);
        Cat garfield = new Cat("Garfield", 6, 35, Sex.MALE, 6, LocalDate.of(2020, 02, 15), "Lazy", true, false );
        Cat sylvester = new Cat("Sylvester", 5, 40, Sex.MALE, 8, LocalDate.of(2021, 01, 24), "Hunter", true, true);
        Dog lassie = new Dog("Lassie", 10, 80, Sex.FEMALE, 12, LocalDate.of(2018, 03, 04), "Collie", "Brown", true);
        Bird tweety = new Bird("Tweety", 1, 10, Sex.FEMALE, 3, LocalDate.of(2022, 02, 24), "Yellow", Size.SMALL);
        store.addAnimal(tom);
        store.addAnimal(garfield);
        store.addAnimal(sylvester);
        store.addAnimal(lassie);
        store.addAnimal(tweety);
        // add animals manually
        boolean another = true;
        /*while (another) {
            store.inputAnimal();
            System.out.printf("Do you want to add another animal (Y/N)?: ");
            if (input.nextLine().equalsIgnoreCase("n")) {
                another = false;
            }
        }*/
        System.out.println("-----------------------------------------------------");
        store.showAnimals();
        System.out.println("-----------------------------------------------------");
        store.verifyDeadAnimals();
    }
}