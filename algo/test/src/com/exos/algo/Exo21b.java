package com.exos.algo;

import java.util.Scanner;

public class Exo21b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tiniest = 0;
        System.out.println("Comparator 2000");
        System.out.println("This machine receives 10 numbers and tells you which is the tiniest of all.");
        System.out.println("Please enter the numbers:");
        for (int i=1; i <= 10; i++) {
            System.out.print(i + ". ");
            int number = Integer.parseInt(input.nextLine());
            if (i == 1) {
                tiniest = number;
            }
            if (number < tiniest) {
                tiniest = number;
            }
        }
        System.out.println("The tiniest number of all is: " + tiniest);
    }
}
