package org.example.tu;

// a program takes the value of 3 sides of a triangle. the program tells us if the triangle is equilateral, isosceles or scalene.

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*; // we import static to use assertEquals() directly

public class TriangleTest {

    @Test
    @DisplayName("Valid arguments")
    void validArguments() {
        int a=1, b=2, c=1;
        assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);},"All values must be greater than 0.");
    }

    @Test
    @DisplayName("Invalid arguments caused by value = 0")
    void invalidArgumentsCausedBy0() {
        int a=0, b=2, c=1;
        assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);});
    }

    @Test
    @DisplayName("Invalid arguments caused by negative values")
    void invalidArgumentsCausedByNegative() {
        int a=1, b=2, c=-1;
        assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);});
    }

    @Test
    @DisplayName("type() for equilateral triangle success")
    void equilateralTriangleSuccess() {
        int a=3, b=3, c=3;
        assertEquals("equilateral", new Triangle(a,b,c).type());
    }

}
