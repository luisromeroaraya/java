package com.exos.algo;

import java.util.Scanner;

public class Exo19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("10th Power Machine 2000");
        System.out.println("This machine can calculate the 10th power of any number (x^10).");
        System.out.print("Please enter a number: ");
        int x = Integer.parseInt(input.nextLine());
        int power = x;
        for (int i=1; i <10; i++) {
            power = power * x;
        }
        System.out.println(x + "^10 = " + power);
    }
}
