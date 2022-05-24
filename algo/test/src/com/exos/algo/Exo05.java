package com.exos.algo;

import java.util.Scanner;

public class Exo05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a number of seconds: ");
        int total = Integer.parseInt(input.nextLine());
        // 1 minute = 60 seconds, 1 hour =  3600 seconds, 1 day = 86400 seconds
        int days = total / 86400;
        int hours = (total % 86400) / 3600;
        int minutes = ((total % 86400) % 3600) / 60;
        int seconds = ((total % 86400) % 3600) % 60;
        System.out.printf("%s days, %s hours, %s minutes, %s seconds", days, hours, minutes, seconds);
    }
}
