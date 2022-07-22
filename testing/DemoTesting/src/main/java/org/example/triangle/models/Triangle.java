package org.example.triangle.models;

public class Triangle {
    private int a;
    private int b;
    private int c;

    // constructor
    public Triangle(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("All values must be greater than 0.");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("The sum of the lengths of any two sides of a triangle must be greater than the length of the third side.");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // getters
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public int getC() {
        return c;
    }

    // setters
    public void setA(int a) {
        if (a <= 0) {
            throw new IllegalArgumentException("Value must be greater than 0.");
        }
        this.a = a;
    }
    public void setB(int b) {
        if (b <= 0) {
            throw new IllegalArgumentException("Value must be greater than 0.");
        }
        this.b = b;
    }
    public void setC(int c) {
        if (c <= 0) {
            throw new IllegalArgumentException("Value must be greater than 0.");
        }
        this.c = c;
    }

    // methods
    public String type() {
        if (a == b && b == c) {
            return "equilateral";
        }
        else if (a == b || b == c || a == c) {
            return "isosceles";
        }
        else {
            return "scalene";
        }
    }
}
