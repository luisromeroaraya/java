package com.exos.algo;

public class Exo25 {
    public static void main(String[] args) {
        int[] table = new int[]{1, 2, 3, 4, 5};
        int[] mirror = new int[table.length];
        for(int i=0; i<table.length; i++) {
            mirror[i] = table[table.length-1-i];
        }
        for (int elem: mirror) {
            System.out.printf("%s ", elem);
        }
    }
}
