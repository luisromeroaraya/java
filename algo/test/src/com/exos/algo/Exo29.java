package com.exos.algo;

import java.util.Scanner;

public class Exo29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] table = new int[]{1,0,0,0,0,0,0,0,0,0};
        int index = 0;
        boolean stop = false;
        System.out.println("You are a pawn in the first position of a table and you can move to the left or to the right.");
        do {
            for(int elem: table) {
                System.out.printf("%s ", elem);
            }
            System.out.printf("Do you want to move left or right or you want to stop (L/R/S)?: ");
            String answer = input.nextLine().toLowerCase();
            int temp = table[index];
            if(answer.startsWith("l")) {
                if(index == 0){
                    table[index] = table[table.length-1];
                    table[table.length-1] = temp;
                    index = table.length-1;
                }
                else {
                    table[index] = table[index-1];
                    table[index-1] = temp;
                    index = index-1;
                }
            }
            else if(answer.startsWith("r")) {
                if(index == (table.length-1)) {
                    table[index] = table[0];
                    table[0] = temp;
                    index = 0;
                }
                else {
                    table[index] = table[index+1];
                    table[index+1] = temp;
                    index = index+1;
                }
            }
            else {
                stop = true;
            }
        } while(!stop);
    }
}
