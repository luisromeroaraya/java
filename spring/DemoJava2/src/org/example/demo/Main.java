package org.example.demo;

import org.example.demo.models.Dog;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dog> list = Arrays.asList(
                new Dog("Titus", 3, Color.WHITE),
                new Dog("Tito", 6, Color.ORANGE),
                new Dog("Lassie", 8, Color.WHITE),
                new Dog("Rex", 1, Color.YELLOW)
        );

        searchByName(list, "titus");

        System.out.println("-----------------------------------------------");

        searchByCriteria(list, (dog) -> dog.getName().contains("Tit") && dog.getColor().equals(Color.ORANGE));

        System.out.println("-----------------------------------------------");

        int sum = Stream.of(1,2,3,4,5,6,7,8,9)
                .filter(n -> n % 2 != 0)
                .reduce(0, (accumulator, n) -> accumulator + (n*n));
        System.out.println(sum);

        System.out.println("-----------------------------------------------");

        int sum2 = Stream
                .iterate(1, n -> n + 1) // we can create the list of numbers using iterate and limit
                .limit(9)
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .peek(System.out::println)
                .reduce(0, Integer::sum);
        System.out.println(sum2);
    }

    public static void searchByName(List<Dog> list, String name) {
        for (Dog dog : list) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println(dog);
            }
        }
    }

    public static void searchByCriteria(List<Dog> list, Predicate<Dog> predicate) {
        for (Dog dog : list) {
            if (predicate.test(dog)) {
                System.out.println(dog);
            }
        }
    }
}
