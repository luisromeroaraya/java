package com.oop.race;

import com.oop.race.model.Car;
import com.oop.race.model.Circuit;
import com.oop.race.model.Driver;
import com.oop.race.model.Race;

public class Main {
    public static void main(String[] args) {
        Car toyota = new Car("Toyota", "Supra", 100, 230);
        Car mitsubishi = new Car("Mitsubishi", "GTO", 80, 250);
        Car dodge = new Car("Dodge", "Viper" , 90, 240);
        Car subaru = new Car("Subaru", "Impreza", 95, 235);
        Circuit monza = new Circuit("Monza", 6);
        Driver james = new Driver("James", toyota);
        Driver therence = new Driver("Therence", mitsubishi);
        Driver yassin = new Driver("Yassin", dodge);
        Driver max = new Driver("Max", subaru);
        Race race = new Race("Race 2000", monza,53);
        race.addDriver(james);
        race.addDriver(therence);
        race.addDriver(yassin);
        race.addDriver(max);
        race.makeRace();
        System.out.println("Total time:");
        System.out.println(yassin.getName() + ", " + timeFormat(yassin.getTotalTime()));
        System.out.println(james.getName() + ", " + timeFormat(james.getTotalTime()));
        System.out.println(max.getName() + ", " + timeFormat(max.getTotalTime()));
        System.out.println(therence.getName() + ", " + timeFormat(therence.getTotalTime()) + "\n");
        Driver winner = race.findWinner();
        System.out.println("After " + race.getLaps() + " laps, the winner is " + winner.toString() + " with a total time of " + timeFormat(winner.getTotalTime()));
    }

    public static String timeFormat(int total) {
        // 1 minute = 60 seconds, 1 hour =  3600 seconds, 1 day = 86400 seconds
        // int days = total / 86400;
        int hours = (total % 86400) / 3600;
        int minutes = ((total % 86400) % 3600) / 60;
        int seconds = ((total % 86400) % 3600) % 60;
        return hours + "h " + minutes + "m " + seconds + "s.";
    }
}
