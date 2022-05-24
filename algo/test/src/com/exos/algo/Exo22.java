package com.exos.algo;

import java.util.Scanner;

public class Exo22 {
    public static void main(String[] args) {
        int[] numbers = new int[6];
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 6 numbers:");
        for(int i = 0; i < 6; i++) {
            System.out.printf("%s. ", (i+1));
            numbers[i] = Integer.parseInt(input.nextLine());
        }
        for (int elem: numbers) {
            System.out.printf("%s ", elem);
        }
    }
}
