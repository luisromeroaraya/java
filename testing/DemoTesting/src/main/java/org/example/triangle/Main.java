package org.example.triangle;

import org.example.triangle.models.Triangle;

public class Main {
    public static void main(String[] args) {
        try{
            Triangle triangle1 = new Triangle(1,2,3);
            System.out.println(String.format("Triangle1 (%s,%s,%s) created successfully. Type of triangle: %s", triangle1.getA(), triangle1.getB(), triangle1.getC(), triangle1.type()));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle2 = new Triangle(0,4,5);
            System.out.println(String.format("Triangle2 (%s,%s,%s) created successfully. Type of triangle: %s", triangle2.getA(), triangle2.getB(), triangle2.getC(), triangle2.type()));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle3 = new Triangle(-1,4,5);
            System.out.println(String.format("Triangle3 (%s,%s,%s) created successfully. Type of triangle: %s", triangle3.getA(), triangle3.getB(), triangle3.getC(), triangle3.type()));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle4 = new Triangle(3,4,5);
            System.out.println(String.format("Triangle4 (%s,%s,%s) created successfully. Type of triangle: %s", triangle4.getA(), triangle4.getB(), triangle4.getC(), triangle4.type()));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
