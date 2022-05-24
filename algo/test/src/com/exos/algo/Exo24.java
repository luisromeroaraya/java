package com.exos.algo;

import java.util.Scanner;

public class Exo24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of players (1-10): ");
        int number = Integer.parseInt(input.nextLine());
        while((number < 1) || (number > 10)) {
            System.out.print("Invalid number of players. Please choose again (1-10): ");
            number = Integer.parseInt(input.nextLine());
        }
        int[] players = new int[number];
        for(int i = 0; i < number; i++) {
            System.out.printf("Please enter the score for player %s: ", (i+1));
            players[i] = Integer.parseInt(input.nextLine());
        }
        int total = 0;
        double average = 0;
        for (int elem: players) {
            total = total + elem;
        }
        average = (double) total / number;
        System.out.println("The average score is: " + average);
    }
}
