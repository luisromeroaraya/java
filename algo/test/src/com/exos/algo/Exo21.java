package com.exos.algo;

import java.util.Random;
import java.util.Scanner;

public class Exo21 {
    public static void main(String[] args) {
        int max = 101;
        Random random = new Random();
        int rightPrice = random.nextInt(max);
        int price = 0;
        int tries = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("The Right Price 2000");
        System.out.println("Guess the price of the product to win!");
        while (price != rightPrice) {
            System.out.print("How much do you think this product costs? (1-100): ");
            String answer = input.nextLine();
            while (!isValid(answer)) {
                System.out.print("\"" + answer + "\"" + " is not a valid number. Please enter a number (1-100): ");
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
        System.out.printf("Your guess after %s tries is right! You won a %s euros product.", tries, price);
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
