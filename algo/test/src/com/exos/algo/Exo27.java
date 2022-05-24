package com.exos.algo;

import java.util.Scanner;

public class Exo27 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] table = new int[10];
        System.out.println("Comparator 2000");
        System.out.println("This machine receives 10 numbers and tells you which is the tiniest of all.");
        System.out.println("Please enter the numbers:");
        for(int i = 0; i < table.length; i++) {
            System.out.print((i+1) + ". ");
            table[i] = Integer.parseInt(input.nextLine());
        }
        int tiniest = 0;
        for(int i=0; i<(table.length-1); i++) {
            if(i == 0){
                tiniest = table[0];
            }
            else if(table[i] < tiniest) {
                tiniest = table[i];
            }
        }
        System.out.println("The tiniest number of all is: " + tiniest);

//        for(int i=0; i<(table.length-1); i++) {
//            for(int j=0; j<(table.length-1); j++) {
//                if (table[j] > table[j+1]) {
//                    int temp = table[j];
//                    table[j] = table[j+1];
//                    table[j+1] = temp;
//                }
//            }
//        }
//        System.out.println("The tiniest number of all is: " + table[0]);
    }
}
