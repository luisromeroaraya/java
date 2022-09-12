package com.exceptions.m3;

public class TryWithResourcesReverseClose {

    public static void main(String[] args) {

        try (var one = new MyResource("One");
             var two = new MyResource("Two")) {
                throw new RuntimeException();
        }


    }
}
