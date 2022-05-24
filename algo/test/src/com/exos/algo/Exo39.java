package com.exos.algo;

import java.util.Scanner;

public class Exo39 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Fibonnacci Value Calculator 2000");
        System.out.println("This machine gives you the value of the value of the Fibonnacci sequence of given index.");
        System.out.printf("Please enter the index: ");
        int index = Integer.parseInt(input.nextLine());
        System.out.println("The value of f(" + index + ") = " + value(index));
        System.out.println(recursive(index));
    }

    public static int value(int index) {
        int value = 0;
        int a = 0;
        int b = 1;
        for(int i=0; i<=index; i++) {
            if (i==0) {
                value = a;
            }
            else if (i==1) {
                value = b;
            }
            else {
                value = a + b;
                a = b;
                b = value;
            }
            System.out.printf("%s ", value);
        }
        return value;
    }

    public static int recursive(int index) {
        if (index < 2) {
            return index;
        }
        return recursive(index-2) + recursive(index-1);
    }
}
