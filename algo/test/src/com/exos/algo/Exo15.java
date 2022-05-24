package com.exos.algo;

public class Exo15 {
    public static void main(String[] args) {
        for (int i=1; i<10; i++) {
            for (int j=1; j<=10; j++) {
                int result = j * i;
                System.out.printf("%s * %s = %s", i, j, result);
                System.out.println("");
            }
        }
    }
}
