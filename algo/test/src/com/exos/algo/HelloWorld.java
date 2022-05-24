package com.exos.algo;

public class HelloWorld {
    public static void main(String[] args) {
        int a;
        a = 5;
        final double b = 5.2;
        // b = 5.3; -> ne fonctionne pas car la variable est final
        boolean c = true;
        String message = "Bonjour tout le monde";
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(message);
    }
}
