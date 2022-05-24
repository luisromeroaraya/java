package com.exos.algo;

import java.util.Scanner;

public class Exo31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] table = new int[]{5,4,2,7,8,10,1,3,6,9};
        boolean found = false;
        System.out.println("Finder 2000");
        System.out.println("This machine verifies if a given number is in a table.");
        System.out.printf("Please enter a number (1-10): ");
        int number = Integer.parseInt(input.nextLine());
        for(int element : table) {
            if (element == number) {
                found = true;
            }
        }
        if (found) {
            System.out.println(number + " is in this table!");
        }
        else {
            System.out.println(number + " is not in this table.");
        }
        for(int element : table) {
            if (element == number) {
                System.out.printf("*%s* ", element);
            }
            else {
                System.out.printf("%s ", element);
            }
        }
    }
}
