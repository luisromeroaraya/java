package com.exos.algo;

import java.util.Scanner;

public class Exo07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a year: ");
        int year = Integer.parseInt(input.nextLine());
        // Une année est bissextile si elle est divisible par 4, mais non divisible par 100. Ou si elle est divisible par 400.
        if ( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("The year " + year + " is a leap year.");
        }
        else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}
