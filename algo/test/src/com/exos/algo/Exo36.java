package com.exos.algo;

import java.util.Scanner;

public class Exo36 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Word Inverter 2000");
        System.out.println("This machine inverts a given word.");
        System.out.printf("Please enter a word: ");
        String word = input.nextLine();
        System.out.println("The inverted word is: " + invert(word));
    }

    public static String invert(String word) {
        String inverted="";
        for (int i=0; i<word.length(); i++) {
            inverted = inverted + word.charAt(word.length() - 1 - i);
        }
        return inverted;
    }
}
