package com.combat;

import com.combat.models.Battle;
import com.combat.models.Creature;
import com.combat.models.Trainer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Creature pikachu = new Creature("Pikachu", 6, 3, 12);
        System.out.println(pikachu.toString());
        Creature bulbasaur = new Creature("Bulbasaur", 6, 9, 6);
        System.out.println(bulbasaur.toString());
        Creature snorlax = new Creature("Snorlax", 6, 6, 3);
        System.out.println(snorlax.toString());
        Creature jigglypuff = new Creature("Jiggly Puff", 3, 6, 8);
        System.out.println(jigglypuff.toString());
        Creature squirtle = new Creature("Squirtle", 4, 5, 8);
        System.out.println(squirtle.toString());
        Creature blastoise = new Creature("Blastoise", 9, 9, 1);
        System.out.println(blastoise.toString());
        Trainer ash = new Trainer("Ash Ketchum");
        Trainer brock = new Trainer("Brock");
        ash.addCreature(pikachu);
        ash.addCreature(bulbasaur);
        ash.addCreature(snorlax);
        brock.addCreature(jigglypuff);
        brock.addCreature(squirtle);
        brock.addCreature(blastoise);
        Battle battle = new Battle();
        battle.addTrainer(ash);
        battle.addTrainer(brock);
        System.out.println(ash.toString());
        System.out.println(brock.toString());
        battle.fight(ash, brock);
    }

    public static void createCreature(Creature creature) {
        Scanner input = new Scanner(System.in);
        String name = "";
        int points = 42;
        int strength, armor, speed, health = 0;
        System.out.printf("Choose a name for your creature: ");
        name = input.nextLine();
        System.out.println("Each creature can have a maximum of "+ points + " points of stats.");
        System.out.println("You can distribute them as you wish between Force(1-10), Armor(0-10), Speed(1-10) and Health(1-15).");
        System.out.printf("Choose the number of points to give to Force(1-10): ");
        strength = Integer.parseInt(input.nextLine());
        points = points - strength;
        System.out.println("You still have " + points + " points.");
        System.out.printf("Choose the number of points to give to Armor(0-10): ");
        armor = Integer.parseInt(input.nextLine());
        points = points - armor;
        System.out.println("You still have " + points + " points.");
        System.out.printf("Choose the number of points to give to Speed(1-10): ");
        speed = Integer.parseInt(input.nextLine());
        points = points - speed;
        System.out.println(points + " points have been automatically assigned to Health.");
        health = points;
        creature.setName(name);
        creature.setStrength(strength);
        creature.setArmor(armor);
        creature.setSpeed(speed);
        creature.setHealth(health);
    }
}
