package oop;

import oop.model.Horse;
import oop.model.Knight;

public class Main {
    public static void main(String[] args) {
        Horse jolly = new Horse("Jolly Jumper", 50, 70);
        System.out.printf("Horse: %s, Min speed: %skm/h, Max speed: %skm/h",jolly.getName(), jolly.getSpeedMin(), jolly.getSpeedMax());
        System.out.println("");
        System.out.println(jolly.toString());
        Horse.neigh(); // you have access to static methods in the Horse class;

        Horse seabiscuit = new Horse("Sea Biscuit");
        System.out.println(seabiscuit.getName());
        System.out.println(seabiscuit.toString());
        Horse.neigh(); // you have access to static methods in the Horse class;

        Horse rosinante = new Horse ("Rosinante", 20, 60);
        System.out.println(rosinante.getName());
        System.out.println(rosinante.toString());
        Horse.neigh(); // you have access to static methods in the Horse class;

        Knight quijote = new Knight("Don Quijote", "de la Mancha");
        quijote.addHorse(rosinante);
        quijote.addHorse(jolly);

        System.out.println(quijote.getHorses().toString());
        System.out.println(quijote.getHorses().get(rosinante.getName()).run());

    }
}
