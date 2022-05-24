package com.exos.algo;

import java.util.Scanner;

public class Exo08 {
    public static void main(String[] args) {
        int balls = 10;
        boolean ready = false, pannierVide = false;
        Scanner input = new Scanner(System.in);
        while (!pannierVide) {
            System.out.println("Are you ready? (Yes / No)");
            String response = input.nextLine().toLowerCase();
            if (response.equals("yes")) {
                ready = true;
            }
            else {
                ready = false;
            }
            if (ready) {
                System.out.println("There goes a ball!"); // throwBall
                balls = balls - 1;
                if (balls == 0) {
                    pannierVide = true;
                }
                System.out.println("Remaining balls: " + balls);
            }
            else {
                System.out.println("Please get ready.");
            }
        }
    }
}
