package org.example.tu;

// a program takes the value of 3 sides of a triangle. the program tells us if the triangle is equilateral, isosceles or scalene.

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*; // we import static to use assertEquals() directly

public class TriangleTest {

    // Valid arguments tests
    @Test
    @DisplayName("Valid arguments greater than 0")
    void validArgumentsGreaterThan0() {
        int a=3, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = FALSE => DOES NOT THROW EXCEPTION -> (3 + 4 <= 5 || 3 + 5 <= 4 || 4 + 5 <= 3) = FALSE => DOES NOT THROW EXCEPTION
        assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);},"All values must be greater than 0.");
    }

    @Test
    @DisplayName("Valid triangle sides")
    void validArgumentsTriangleSides() {
        int a=3, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = FALSE => DOES NOT THROW EXCEPTION -> (3 + 4 <= 5 || 3 + 5 <= 4 || 4 + 5 <= 3) = FALSE => DOES NOT THROW EXCEPTION
        assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);},"The sum of the lengths of any two sides of a triangle must be greater than the length of the third side.");
    }

    @Test
    @DisplayName("Invalid arguments caused by value = 0")
    void invalidArgumentsCausedBy0() {
        int a=0, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
        assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
    }

    @Test
    @DisplayName("Invalid arguments caused by negative values")
    void invalidArgumentsCausedByNegative() {
        int a=3, b=-4, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
        assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
    }

    @Test
    @DisplayName("Invalid arguments caused by impossible triangle side values")
    void invalidArgumentsCausedByImpossibleTriangleSideValues() {
        int a=1, b=2, c=3; // (1 + 2 <= 3 || 3 + 5 <= 4 || 4 + 5 <= 3) = TRUE => THROWS EXCEPTION
        assertEquals("The sum of the lengths of any two sides of a triangle must be greater than the length of the third side.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
    }

    // type() method tests
    @Test
    @DisplayName("type() for equilateral triangle success")
    void typeEquilateralTriangleSuccess() {
        int a=3, b=3, c=3;
        assertEquals("equilateral", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for isosceles triangle success (a == b)")
    void typeIsoscelesTriangleSuccess01() {
        int a=3, b=3, c=5;
        assertEquals("isosceles", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for isosceles triangle success (a == c)")
    void typeIsoscelesTriangleSuccess02() {
        int a=3, b=5, c=3;
        assertEquals("isosceles", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for isosceles triangle success (b == c)")
    void typeIsoscelesTriangleSuccess03() {
        int a=5, b=3, c=3;
        assertEquals("isosceles", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for scalene triangle success")
    void typeScaleneTriangleSuccess() {
        int a=3, b=4, c=5;
        assertEquals("scalene", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for equilateral triangle fail")
    void typeEquilateralTriangleFail() {
        int a=3, b=4, c=5;
        assertNotEquals("equilateral", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for isosceles triangle fail")
    void typeIsoscelesTriangleFail() {
        int a=3, b=4, c=5;
        assertNotEquals("isosceles", new Triangle(a,b,c).type());
    }

    @Test
    @DisplayName("type() for scalene triangle fail")
    void typeScaleneTriangleFail() {
        int a=3, b=4, c=4;
        assertNotEquals("scalene", new Triangle(a,b,c).type());
    }
}
