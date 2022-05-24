package com.exos.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Exo35 {
    public static void main(String[] args) {
        ArrayList<Integer> table1 = new ArrayList<>(Arrays.asList(7, 6, 2, 1));
        ArrayList<Integer> table2 = new ArrayList<>(Arrays.asList(9, 3, 4, 5, 8, 11, 12, 10));
        ArrayList<Integer> table3 = new ArrayList<>(table1.size() + table2.size());
        System.out.println("This machine puts all the unordered values from 2 tables in order into a 3rd table.");
        System.out.println("Table 1: " + table1);
        System.out.println("Table 2: " + table2);
        System.out.println("Table 3: " + table3);
        System.out.println("");
        fusion(table1, table2, table3);
        System.out.println("Table 1: " + table1);
        System.out.println("Table 2: " + table2);
        System.out.println("Table 3: " + table3);
        System.out.println("");
    }

    public static void fusion(ArrayList<Integer> table1, ArrayList<Integer> table2, ArrayList<Integer> table3) {
        while (table1.size()>0 || table2.size()>0) {
            int min1 = 0;
            int min2 = 0;
            for (int i = 0; i < table1.size(); i++) {
                if (table1.get(min1) > table1.get(i)) {
                    min1 = i;
                }
            }
            for (int j = 0; j < table2.size(); j++) {
                if (table2.get(min2) > table2.get(j)) {
                    min2 = j;
                }
            }
            if ((table1.size() > 0) && (table2.size() > 0)) {
                if (table1.get(min1) < table2.get(min2)) {
                    table3.add(table1.get(min1));
                    table1.remove(min1);
                } else {
                    table3.add(table2.get(min2));
                    table2.remove(min2);
                }
            } else if (table1.size() < 1) {
                table3.add(table2.get(min2));
                table2.remove(min2);
            } else {
                table3.add(table1.get(min1));
                table1.remove(min1);
            }
        }
    }
}