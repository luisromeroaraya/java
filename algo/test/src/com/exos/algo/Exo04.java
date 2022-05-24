package com.exos.algo;

import java.util.Scanner;

public class Exo04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the first variable:");
        String aString = input.nextLine();
        int a = Integer.parseInt(aString);
        System.out.println("Please input the second variable:");
        String bString = input.nextLine();
        int b = Integer.parseInt(bString);
        System.out.println("The original variables are:" + " a = " + a + ", b = " + b);
        b = a + b;
        a = b - a;
        b = b - a;
        System.out.println("The inverted variables are:" + " a = " + a + ", b = " + b);
    }
}
