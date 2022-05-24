package com.exos.algo;

import java.util.Scanner;

public class Exo28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] table = new int[]{5,4,2,7,8,10,1,3,6,9};
        int index = -1;
        System.out.println("Finder 2000");
        System.out.println("This machine search the position of a value in a table.");
        System.out.printf("Please enter a number (1-10): ");
        int number = Integer.parseInt(input.nextLine());
        for(int i=0; i<(table.length-1); i++) {
            if (table[i] == number) {
                index = i;
            }
        }
        if (index == -1) {
            System.out.println("The value is not in this table.");
        }
        else {
            System.out.printf("The value is in the position [%s] of the table.", index);
        }
    }
}
