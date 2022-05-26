package com.heroes;

import com.heroes.models.Battleground;

public class Main {
    public static void main(String[] args) {
        Battleground shorewood = new Battleground("Shorewood");
        shorewood.createCharacter("Marcelo", "Human");
        shorewood.createCharacter("James", "Dragon");
        shorewood.createCharacter("Therence", "Orc");
        shorewood.createCharacter("Yassin", "Orc");
        shorewood.createCharacter("Max", "Orc");
        shorewood.createCharacter("Sebastien", "Orc");
        shorewood.createCharacter("Thabit", "Wolf");
        shorewood.createCharacter("Chidi", "Wolf");
        shorewood.createCharacter("Rufat", "Wolf");
        shorewood.createCharacter("Giusseppe", "Wolf");
        shorewood.createCharacter("Abed", "Wolf");
        shorewood.createCharacter("Rami", "Wolf");
        // shorewood.inputCharacter();
        // shorewood.showCharacters();
        // System.out.println("----------------------------------");
        // shorewood.getHeroes().get(0).battleRoyal(shorewood);
        shorewood.getHeroes().get(0).adventure(shorewood);

    }
}
