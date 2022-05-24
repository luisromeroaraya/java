package com.exos.algo;

import java.util.Scanner;

public class Exo37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Word Inverter 2000");
        System.out.println("This machine inverts a given word.");
        System.out.printf("Please enter a word: ");
        String word = input.nextLine();
        if (isPalindrome(word)) {
            System.out.println("The word " + word + " is a palindrome.");
        }
        else {
            System.out.println("The word " + word + " isn't a palindrome.");
        }
    }

    public static boolean isPalindrome(String word) {
        String inverted="";
        for (int i=0; i<word.length(); i++) {
            inverted = inverted + word.charAt(word.length() - 1 - i);
        }
        if (word.equals(inverted)) {
            return true;
        }
        else {
            return false;
        }
    }
}
