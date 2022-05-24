package com.exos.algo;

import java.util.Scanner;

public class Exo01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Please input the first variable: ");
        String aString = input.nextLine();
        int a = Integer.parseInt(aString);
        System.out.printf("Please input the second variable: ");
        String bString = input.nextLine();
        int b = Integer.parseInt(bString);
        System.out.println("The original variables are:" + " a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("The inverted variables are:" + " a = " + a + ", b = " + b);
    }
}