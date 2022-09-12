package com.exceptions.m4.errors;

public class InitErrorExample {

    // cause 1
    static int n = 2/ 0;

    static {
        // cause 2
        int n = 1;
        if (n < 2)
            throw new IllegalArgumentException();
    }
    public static void main(String[] args) {

    }
}
