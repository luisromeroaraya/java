package com.exos.algo;

import java.util.Scanner;

public class Exo16 {
    public static void main(String[] args) {
        int rightPrice = 325;
        int price = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("The Right Price 2000");
        while (price != rightPrice) {
            System.out.print("How much do you think a bike costs?: ");
            price = Integer.parseInt(input.nextLine());
            if (price < rightPrice) {
                System.out.println("The Right Price is higher. Please try again.");
            } else if (price > rightPrice) {
                System.out.println("The Right Price is lower. Please try again.");
            }
        }
        System.out.printf("Your guess is right! You won a %s euros bike.", price);
    }

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


}
