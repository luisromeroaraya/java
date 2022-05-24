package com.exos.algo;

import java.util.Scanner;

public class Exo21c {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This machine receives a number of Repetitions, a number of Hyphens and a number of Blank Spaces and prints the result on screen.");
        System.out.print("Please enter a number of Repetitions: ");
        int repetitions = Integer.parseInt(input.nextLine());
        System.out.print("Please enter a number of Hyphens: ");
        int hyphens = Integer.parseInt(input.nextLine());
        System.out.print("Please enter a number of Blank Spaces: ");
        int blanks = Integer.parseInt(input.nextLine());
        System.out.print("|");
        for(int i=0; i < repetitions; i++) {
            for(int j=0; j < hyphens; j++) {
                System.out.print("-");
            }
            for(int k=0; k < blanks; k++) {
                System.out.print(" ");
            }
        }
        System.out.print("|");
    }
}
