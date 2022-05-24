package com.exos.algo;

import java.util.Scanner;

public class Exo38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Even Number Calculator 2000");
        System.out.println("This machine shows even numbers between two given numbers.");
        System.out.printf("Please enter the first number: ");
        int min = Integer.parseInt(input.nextLine());
        System.out.printf("Please enter the second number: ");
        int max = Integer.parseInt(input.nextLine());
        System.out.println("Even numbers between " + min + " and " + max + ":");
        evenNumbersBetween(min, max);
    }

    public static void evenNumbersBetween(int min, int max) {
        if (min%2 != 0) {
            min = min+1;
        }
        for(int i=min; i<=max; i=i+2) {
            System.out.printf("%s ", i);
        }
    }
}
