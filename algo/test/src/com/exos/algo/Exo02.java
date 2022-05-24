package com.exos.algo;

import java.util.Scanner;

public class Exo02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // intialize the input grabber
        System.out.print("Please input your First Name: ");
        String firstName = input.nextLine();
        System.out.print("Please input your Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Welcome "+ firstName + " " + lastName + " !");
    }
}
