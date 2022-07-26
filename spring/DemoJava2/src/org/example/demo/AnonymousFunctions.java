package org.example.demo;

import org.example.demo.interfaces.Movement;
import org.example.demo.models.Dog;

import java.awt.*;

public class AnonymousFunctions {
    public static void main(String[] args) {
        Dog titus = new Dog("Titus", 3, Color.BLACK);
        Movement<Dog> functionMovement = (x) -> System.out.println(x.getName() + " moves"); // here I define the function from the interface
        functionMovement.move(titus); // now I can call my function
    }
}
