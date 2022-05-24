package com.exos.algo;

import java.util.Scanner;

public class Exo12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Time Subtractor 2000");
        System.out.println("Please enter the first amount of time: ");
        System.out.print("Number of days: ");
        int days1 = Integer.parseInt(input.nextLine());
        System.out.print("Number of hours: ");
        int hours1 = Integer.parseInt(input.nextLine());
        System.out.print("Number of minutes: ");
        int minutes1 = Integer.parseInt(input.nextLine());
        System.out.print("Number of seconds: ");
        int seconds1 = Integer.parseInt(input.nextLine());
        System.out.println("Please enter the second amount of time: ");
        System.out.print("Number of days: ");
        int days2 = Integer.parseInt(input.nextLine());
        System.out.print("Number of hours: ");
        int hours2 = Integer.parseInt(input.nextLine());
        System.out.print("Number of minutes: ");
        int minutes2 = Integer.parseInt(input.nextLine());
        System.out.print("Number of seconds: ");
        int seconds2 = Integer.parseInt(input.nextLine());
        int totalSeconds1 = seconds1 + (minutes1 * 60) + (hours1 * 3600) + (days1 * 86400);
        int totalSeconds2 = seconds2 + (minutes2 * 60) + (hours2 * 3600) + (days2 * 86400);
        int total = totalSeconds1 - totalSeconds2;
        int days = total / 86400;
        int hours = (total % 86400) / 3600;
        int minutes = ((total % 86400) % 3600) / 60;
        int seconds = ((total % 86400) % 3600) % 60;
        System.out.printf("The difference between them is of: %s days, %s hours, %s minutes, %s seconds", days, hours, minutes, seconds);
    }
}
