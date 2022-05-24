package com.exos.algo;

import java.util.Random;
import java.util.Scanner;

public class Exo21d {
    public static void main(String[] args) {
        Random random = new Random();
        int rightPrice = 0;
        int max = 0;
        int price = 0;
        int tries = 0;
        boolean again = false;
        Scanner input = new Scanner(System.in);
        System.out.println("The Right Price 2000");
        System.out.println("Guess the price of the product to win!");
        do {
            System.out.print("Choose a level (Easy/Medium/Hard): ");
            String level = input.nextLine().toLowerCase();
            while (!level.equals("easy") ^ level.equals("medium") ^ level.equals("hard")) {
                System.out.print("This is not a valid level. Please choose again (Easy/Medium/Hard): ");
                level = input.nextLine().toLowerCase();
            }
            switch(level) {
                case "easy":
                    max = 11;
                    rightPrice = random.nextInt(max);
                    break;
                case "medium":
                    max = 101;
                    rightPrice = random.nextInt(max);
                    break;
                case "hard":
                    max = 1001;
                    rightPrice = random.nextInt(max);
                    break;
            }

            while ((price != rightPrice) && (tries < 10)) {
                System.out.printf("How much do you think this product costs? (1-%s): ", (max-1));
                String answer = input.nextLine();
                while (!isValid(answer)) {
                    System.out.printf("\"%s\" is not a valid number. Please enter a number (1-%s): ", answer, (max-1));
                    answer = input.nextLine();
                }
                price = Integer.parseInt(answer);
                if (price < rightPrice) {
                    System.out.println("The Right Price is higher. Please try again.");
                } else if (price > rightPrice) {
                    System.out.println("The Right Price is lower. Please try again.");
                }
                tries++;
            }
            if (price != rightPrice) {
                System.out.println("You couldn't find the right price after 10 tries. You lost!");
                System.out.printf("The right price was: %s euros.", rightPrice);
            }
            else {
                System.out.printf("Your guess after %s tries is right! You won a %s euros product.", tries, price);
            }
            System.out.println("");
            System.out.println("Do you want to play again (Yes/No)?");
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                again = true;
            }
            else {
                again = false;
            }
        } while(again);
    }

    public static boolean isValid(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        if (Integer.parseInt(string) > 0 && Integer.parseInt(string) < 101) {
            return true;
        }
        else {
            return false;
        }
    }
}

