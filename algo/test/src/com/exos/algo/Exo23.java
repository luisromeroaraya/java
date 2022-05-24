package com.exos.algo;

public class Exo23 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for(int i=0; i<10; i++) {
            if (i == 0) {
                numbers[i] = 2;
            }
            else {
                numbers[i] = 2 * (numbers[i-1]);
            }
        }
        for (int elem: numbers) {
            System.out.printf("%s ", elem);
        }
    }
}
