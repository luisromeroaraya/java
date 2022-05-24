package com.exos.algo;

import java.util.Scanner;

public class Exo20 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This machine can calculate the power of any number (x^n).");
        System.out.print("Please enter a number: ");
        int x = Integer.parseInt(input.nextLine());
        System.out.print("Please enter the exponent: ");
        int n = Integer.parseInt(input.nextLine());
        int power = x;
        for (int i=1; i <n; i++) {
            power = power * x;
        }
        System.out.println(x + "^" + n + " = " + power);
    }
}