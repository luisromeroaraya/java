package com.exos.algo;

import java.util.Scanner;

public class Exo17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize stock
        int coke = 3, cokeZero = 4, fanta = 1, sprite = 2, iceTea = 2;
        String drink = "";
        boolean error = false;
        boolean anotherDrink = false;
        System.out.println("Drink-machine 2000");
        // Show drinks and stock available
        System.out.println("Drinks available:");
        do {
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
                    drink = "Coke";
                    if (coke > 0) {
                        coke--;
                    }
                    else {
                        error = true;
                    }
                    break;
                case 2:
                    drink = "Coke Zero";
                    if (cokeZero > 0) {
                        cokeZero--;
                    }
                    else {
                        error = true;
                    }
                    break;
                case 3:
                    drink = "Fanta";
                    if (fanta > 0) {
                        fanta--;
                    }
                    else {
                        error = true;
                    }
                    break;
                case 4:
                    drink = "Sprite";
                    if (sprite > 0) {
                        sprite--;
                    }
                    else {
                        error = true;
                    }
                    break;
                case 5:
                    drink = "Ice Tea";
                    if (iceTea > 0) {
                        iceTea--;
                    }
                    else {
                        error = true;
                    }
                    break;
            }
            if (error) {
                System.out.println("We don't have " + drink + " anymore.");
            }
            else {
                System.out.println("Please take your " + drink + ".");
            }

            System.out.println("Do you want another drink (Yes/No)?");
            String answer  = input.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                anotherDrink = true;
            }
            else {
                anotherDrink = false;
            }
        } while (anotherDrink);
    }
}
