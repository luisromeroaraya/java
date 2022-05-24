package com.exos.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exo42 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        // String number = String.valueOf(random.nextInt(4)+1)+String.valueOf(random.nextInt(4)+1)+String.valueOf(random.nextInt(4)+1)+String.valueOf(random.nextInt(4)+1);
        String number = String.valueOf(1)+String.valueOf(2)+String.valueOf(3)+String.valueOf(4);
        System.out.println("Mastermind 2000");
        System.out.println("I'm thinking of a 4 digits sequence with numbers from 1 to 4 (example: 1234). Try to guess the sequence.");
        System.out.println("Answer: " + number);
        boolean win = false;
        while(!win) {
            System.out.printf("Make your guess: ");
            String guess = input.nextLine();
            int rightNumber=0;
            int rightPlace=0;
            String temp="";
            for (int i=0; i<4; i++) {
                if (number.charAt(i) == guess.charAt(i)) {
                    rightPlace++;
                }
                else {
                    temp=temp+String.valueOf(number.charAt(i));
                }
            }
            // System.out.println(temp);
            for (int i=0; i<temp.length(); i++) {
                if (temp.contains(String.valueOf(guess.charAt(i)))) {
                    rightNumber++;
                }
            }
            System.out.println(rightPlace + " numbers are in the right place.");
            System.out.println(rightNumber + " numbers are not in the right place.");
            if (rightPlace == 4) {
                win = true;
            }
            else {
                System.out.println("Guess again.");
            }
        }
        System.out.println("You win!");
    }
}

