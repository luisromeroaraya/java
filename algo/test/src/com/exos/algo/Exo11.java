package com.exos.algo;

import java.util.Scanner;

public class Exo11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Grade Converter 2000");
        System.out.print("Please enter your grade in numbers (1-20): ");
        int grade = Integer.parseInt(input.nextLine());
        while ( grade < 0 || grade > 20 ){
            System.out.print("Your grade must be between 1-20. Please write again your grade: ");
            grade = Integer.parseInt(input.nextLine());
        }
        if (grade >= 0 && grade <= 10) {
            System.out.println(grade + " = Insufficient");
        }
        else if (grade >= 11 && grade <= 12) {
            System.out.println(grade + " = Sufficient");
        }
        else if (grade >= 13 && grade <= 15) {
            System.out.println(grade + " = Good");
        }
        else if (grade >= 16 && grade <= 18) {
            System.out.println(grade + " = Very Good");
        }
        else if (grade >= 19 && grade <= 20) {
            System.out.println(grade + " = Excellent");
        }
    }
}
