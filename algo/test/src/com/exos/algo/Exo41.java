package com.exos.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exo41 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> easy = new ArrayList<>(Arrays.asList("tree", "car", "bird", "apple"));
        ArrayList<String> medium = new ArrayList<>(Arrays.asList("parking", "football", "keyboard", "computer"));
        ArrayList<String> hard = new ArrayList<>(Arrays.asList("mischievous", "onomatopoeia", "synecdoche", "thriftless"));
        System.out.println("Hangman 2000");
        System.out.printf("Please choose your level (Easy/Medium/Hard): ");
        String level = input.nextLine().toLowerCase();
        switch(level) {
            case "easy":
                hangman(easy);
                break;
            case "medium":
                hangman(medium);
                break;
            case "hard":
                hangman(hard);
                break;
        }
    }
    public static void hangman(ArrayList<String> words) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int index = random.nextInt(words.size());
        String word = words.get(index);
        String guess = "";
        for (int i=0; i<word.length(); i++) {
            guess = guess + "*";
        }
        System.out.println("Word: " + guess);
        boolean win = false;
        while (!win) {
            System.out.printf("Please enter a letter: ");
            String letter = input.nextLine();
            String temp = "";
            for (int i=0; i<word.length(); i++) {
                if (word.charAt(i) == letter.charAt(0)) {
                    temp = temp + letter;
                }
                else {
                    temp = temp + guess.charAt(i);
                }
            }
            guess = temp;
            System.out.println("Word: " + guess);
            if (word.equals(guess)) {
                win = true;
            }
        }
        System.out.println("You win!");
    }
}
