package com.Animalerie.Models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Animal> animals;

    public Store() {
        this.animals = new ArrayList<>();
    }
    // getters
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    // methods
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void inputAnimal(){
        Scanner input = new Scanner(System.in);
        String type, name, character, race, collar, color;
        int weight, height, age;
        boolean paws, longHair, trained;
        Sex sex;
        Size cage;
        LocalDate date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.printf("Please choose the type of animal (Cat/Dog/Bird): ");
        type = input.nextLine().toLowerCase();
        System.out.printf("Please enter its name: ");
        name = input.nextLine();
        System.out.printf("Please enter its weight in kilos: ");
        weight = Integer.parseInt(input.nextLine());
        System.out.printf("Please enter its height in cms: ");
        height = Integer.parseInt(input.nextLine());
        System.out.printf("Please enter its sex (m/f): ");
        if (input.nextLine().equalsIgnoreCase("m")) {
            sex = Sex.MALE;
        }
        else {
            sex = Sex.FEMALE;
        }
        System.out.printf("Please enter its age in years: ");
        age = Integer.parseInt(input.nextLine());
        System.out.printf("Please enter the date of arrival (yyyy/mm/dd): ");
        date = LocalDate.parse(input.nextLine(), formatter);
        switch(type) {
            case ("cat"):
                System.out.printf("Please describe its personality: ");
                character = input.nextLine();
                System.out.printf("Does it has its paws (Y/N)?: ");
                if (input.nextLine().equalsIgnoreCase("y")) {
                    paws = true;
                }
                else {
                    paws = false;
                }
                System.out.printf("Does it has long hair (Y/N)?: ");
                if (input.nextLine().equalsIgnoreCase("y")) {
                    longHair = true;
                }
                else {
                    longHair = false;
                }
                Cat cat = new Cat(name, weight, height, sex, age, date, character, paws, longHair);
                this.addAnimal(cat);
                break;
            case ("dog"):
                System.out.printf("Please enter its race: ");
                race = input.nextLine();
                System.out.printf("What color is its collar?: ");
                collar = input.nextLine();
                System.out.printf("Is it trained (Y/N)?: ");
                if (input.nextLine().equalsIgnoreCase("y")) {
                    trained = true;
                }
                else {
                    trained = false;
                }
                Dog dog = new Dog(name, weight, height, sex, age, date, race, collar, trained);
                this.addAnimal(dog);
                break;
            case ("bird"):
                System.out.printf("What color is it?: ");
                color = input.nextLine();
                System.out.printf("Does it needs a big or a small cage (Big/Small)?: ");
                if (input.nextLine().equalsIgnoreCase("big")) {
                    cage = Size.BIG;
                }
                else {
                    cage = Size.SMALL;
                }
                Bird bird = new Bird(name, weight, height, sex, age, date, color, cage);
                this.addAnimal(bird);
                break;
        }

    }

    public void showAnimals(){
        int cats = 0;
        int dogs = 0;
        int birds = 0;
        System.out.println("List of animals:");
        for (Animal animal : this.getAnimals()) {
            System.out.println(animal.toString());
            if (animal instanceof Cat) {
                cats++;
            }
            else if (animal instanceof Dog) {
                dogs++;
            }
            else if (animal instanceof Bird) {
                birds++;
            }
        }
        System.out.printf("Cats: %s, Dogs: %s, Birds: %s.\n", cats, dogs, birds);
    }
    public void verifyDeadAnimals() {
        System.out.println("One night has passed. (A random number will be generated for each animal so if n=1 the animal will die)");
        for (Animal animal : this.getAnimals()) {
            System.out.println("Is " + animal.getName() + " alive?: " + animal.isAlive());
        }
    }
}
