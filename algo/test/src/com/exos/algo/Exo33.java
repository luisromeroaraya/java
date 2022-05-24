package com.exos.algo;

import java.util.Scanner;

public class Exo33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This machine returns n^2.");
        System.out.printf("Please enter a number: ");
        int number = Integer.parseInt(input.nextLine());
        System.out.println("n^2 = " + power(number));
    }

    public static int power(Integer number) {
        return number * number;
    }
}
