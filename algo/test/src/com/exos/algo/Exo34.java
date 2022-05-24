package com.exos.algo;

import java.util.Scanner;

public class Exo34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] table = new int[]{5,4,2,7,8,10,1,3,6,9};

        System.out.println("Finder 2000");
        System.out.println("This machine search the position of a value in a table.");
        System.out.printf("Please enter a number (1-10): ");
        int number = Integer.parseInt(input.nextLine());
        if (findIndex(table, number) != -1) {
            System.out.printf("%s is in this position: table[%s].",number, findIndex(table, number));
            System.out.println("");
            for(int element : table) {
                if (element == number) {
                    System.out.printf("*%s* ", element);
                }
                else {
                    System.out.printf("%s ", element);
                }
            }
        }
        else {
            System.out.println(number + " is not in this table.");
            for(int element : table) {
                System.out.printf("%s ", element);
            }
        }

    }

    public static int findIndex(int[] table, int number) {
        int index = -1;
        for(int i=0; i<(table.length-1); i++) {
            if (table[i] == number) {
                index = i;
            }
        }
        return index;
    }

}

