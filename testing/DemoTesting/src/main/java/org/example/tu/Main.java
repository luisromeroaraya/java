package org.example.tu;

public class Main {
    public static void main(String[] args) {
        try{
            Triangle triangle1 = new Triangle(1,2,3);
            System.out.println("Triangle1 (1,2,3) created successfully. Type of triangle: " + triangle1.type());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle2 = new Triangle(0,4,5);
            System.out.println("Triangle2 (0,4,5) created successfully. Type of triangle: " + triangle2.type());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle3 = new Triangle(-1,4,5);
            System.out.println("Triangle3 (-1,4,5) created successfully. Type of triangle: " + triangle3.type());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try{
            Triangle triangle4 = new Triangle(3,4,5);
            System.out.println("Triangle4 (3,4,5) created successfully. Type of triangle: " + triangle4.type());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
