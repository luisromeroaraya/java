package com.exos.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exo30 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> table = new ArrayList<>(Arrays.asList(2,3,7,12,15));
        System.out.println(table);
        System.out.print("Please enter the number to be inserted: ");
        int number = Integer.parseInt(input.nextLine());
        boolean inserted;
        int i = 0;
        // start reading the list and comparing the new value with the value at each position
        do {
            inserted = false;
            // when the new value is smaller than the value at this position it adds it at this position
            if(number<table.get(i)) {
                inserted = true;
                table.add(i,number);
            }
            i++;
        } while(!inserted && i<table.size());
        // if the value is never smaller it means it has to be added at the end
        if(i==table.size()) {
            table.add(number);
        }
        System.out.println("Number has been successfully inserted.");
        System.out.println(table);

    }
}
