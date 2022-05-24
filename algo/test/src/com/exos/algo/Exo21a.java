package com.exos.algo;

import java.util.Scanner;

public class Exo21a {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = "password";
        int error = 0;
        System.out.println("Login Manager 2000");
        System.out.print("Hello User. Please enter your password: ");
        String loginPassword = input.nextLine();
        while ((!loginPassword.equals(password)) && (error < 2)) {
            System.out.print("This is not your password. Please try again: ");
            loginPassword = input.nextLine();
            error++;
        }
        if ((!loginPassword.equals(password)) && (error == 2)) {
            System.out.println("You've failed to input your password 3 times. You're account is now blocked.");
        }
        else {
            System.out.println("You're password is OK. Welcome to the secret area.");
        }
    }
}
