package com.exos.algo;

public class Exo26 {
    public static void main(String[] args) {
        int[] table = new int[]{5, 3, 1, 4, 2};
        // show the unordered table
        System.out.println("Unordered list:");
        for (int elem: table) {
            System.out.printf("%s ", elem);
        }
        int loops = 0;
        System.out.println("");

        // Bubble Sort with 2 for loops:
        System.out.println("Bubble Sort with 2 for loops:");
        for(int i=0; i<(table.length-1); i++) {
            for(int j=0; j<(table.length-1); j++) {
                loops++;
                if (table[j] > table[j+1]) {
                    int temp = table[j];
                    table[j] = table[j+1];
                    table[j+1] = temp;
                }
            }
        }
        // show the inverted table
        for (int elem: table) {
            System.out.printf("%s ", elem);
        }
        System.out.println("Number of loops: " + loops);

        // Bubble Sort with a for and a while
        System.out.println("Bubble Sort with a for and a while:");
        table = new int[]{2, 3, 1, 5, 4};
        boolean permutation;
        loops = 0;
        do {
            permutation = false;
            for(int i=0; i<(table.length-1); i++) {
                loops++;
                if(table[i]>table[i+1]) {
                    permutation = true;
                    int temp = table[i];
                    table[i] = table [i+1];
                    table[i+1] = temp;
                }
            }
        } while (permutation);
        // show the inverted table
        for (int elem: table) {
            System.out.printf("%s ", elem);
        }
        System.out.println("Number of loops: " + loops);

        // Optimized Bubble Sort with a for and a while
        System.out.println("Optimized Bubble Sort with a for and a while:");
        table = new int[]{2, 3, 1, 5, 4};
        int passage = 0;
        loops = 0;
        do {
            permutation = false;
            for(int i=0; i<(table.length-1-passage); i++) {
                loops++;
                if(table[i]>table[i+1]) {
                    permutation = true;
                    int temp = table[i];
                    table[i] = table [i+1];
                    table[i+1] = temp;
                }
            }
            passage++;
        } while (permutation);
        // show the inverted table
        for (int elem: table) {
            System.out.printf("%s ", elem);
        }
        System.out.println("Number of loops: " + loops);
    }
}