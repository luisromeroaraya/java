package com.exos.algo;

import java.util.Scanner;

public class Exo09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize stock
        int coke = 10, cokeZero = 10, fanta = 10, sprite = 10, iceTea = 10;
        System.out.println("Drink-machine 2000");
        // Show drinks and stock available
        System.out.println("Drinks available:");
        System.out.println("1. Coke (Stock: " + coke + "), 2. Coke Zero (Stock: " + cokeZero + "), 3. Fanta (Stock: " + fanta + "), 4. Sprite (Stock: " + sprite + "), 5. Ice Tea (Stock: " + iceTea + ")");
        // Ask for choice
        System.out.print("Please choose your drink (1-5): ");
        int choice = Integer.parseInt(input.nextLine());
        // If number doesn't exist the machine asks the number again
        while (choice < 1 || choice > 5) {
            System.out.print("The choice you made is not available, please choose another drink (1-5): ");
            choice = Integer.parseInt(input.nextLine());
        }
        switch (choice) {
            case 1:
                if (coke > 0) {
                    coke--;
                    System.out.println("Please take your Coke.");
                }
                break;
            case 2:
                if (cokeZero > 0) {
                    cokeZero--;
                    System.out.println("Please take your Coke Zero.");
                }
                break;
            case 3:
                if (fanta > 0) {
                    fanta--;
                    System.out.println("Please take your Fanta.");
                }
                break;
            case 4:
                if (sprite > 0) {
                    sprite--;
                    System.out.println("Please take your Sprite.");
                }
                break;
            case 5:
                if (iceTea > 0) {
                    iceTea--;
                    System.out.println("Please take your Ice Tea.");
                }
                break;
        }
        System.out.printf("1. Coke (Stock: %s), 2. Coke Zero (Stock: %s), 3. Fanta (Stock: %s), 4. Sprite (Stock: %s), 5. Ice Tea (Stock: %s)", coke, cokeZero, fanta, sprite, iceTea);
    }
}
