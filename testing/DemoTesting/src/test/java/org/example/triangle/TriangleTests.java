package org.example.triangle;

// a program takes the value of 3 sides of a triangle. the program tells us if the triangle is equilateral, isosceles or scalene.

import org.example.triangle.models.Triangle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*; // we import static to use assertEquals() directly

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TriangleTests {

    @Nested // used to group tests so the test report is cleaner
    class ValidArgumentsTests {
        // Valid arguments tests
        @Test
        @DisplayName("Valid arguments, all sides greater than 0")
        void validArgumentsGreaterThan0() {
            int a=3, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = FALSE => DOES NOT THROW EXCEPTION -> (3 + 4 <= 5 || 3 + 5 <= 4 || 4 + 5 <= 3) = FALSE => DOES NOT THROW EXCEPTION
            assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);},"All values must be greater than 0.");
        }

        @Test
        @DisplayName("Valid arguments, valid triangle side lengths")
        void validArgumentsTriangleSides() {
            int a=3, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = FALSE => DOES NOT THROW EXCEPTION -> (3 + 4 <= 5 || 3 + 5 <= 4 || 4 + 5 <= 3) = FALSE => DOES NOT THROW EXCEPTION
            assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);},"The sum of the lengths of any two sides of a triangle must be greater than the length of the third side.");
        }
    }

    @Nested
    class InvalidArgumentsTests {
        @Test
        @DisplayName("Invalid arguments caused by a = 0")
        void invalidArgumentsCausedByA0() {
            int a=0, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by a < 0")
        void invalidArgumentsCausedByANegative() {
            int a=-3, b=4, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by b = 0")
        void invalidArgumentsCausedByB0() {
            int a=3, b=0, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by b < 0")
        void invalidArgumentsCausedByBNegative() {
            int a=3, b=-4, c=5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by c = 0")
        void invalidArgumentsCausedByC0() {
            int a=3, b=4, c=0; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by c < 0")
        void invalidArgumentsCausedByCNegative() {
            int a=3, b=4, c=-5; // (a <= 0 || b <= 0 || c <= 0) = TRUE => THROWS EXCEPTION
            assertEquals("All values must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }

        @Test
        @DisplayName("Invalid arguments caused by impossible triangle side values")
        void invalidArgumentsCausedByImpossibleTriangleSideValues() {
            int a=1, b=2, c=3; // (1 + 2 <= 3 || 3 + 5 <= 4 || 4 + 5 <= 3) = TRUE => THROWS EXCEPTION
            assertEquals("The sum of the lengths of any two sides of a triangle must be greater than the length of the third side.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);}).getMessage());
        }
    }

    @Nested
    class TriangleTypeTests {
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

    @Nested
    class SettersTests {
        // setters tests
        @Test
        @DisplayName("setA() success")
        void setASuccess() {
            int a=3, b=3, c=3;
            assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);triangle.setA(4);},"Value must be greater than 0.");
        }

        @Test
        @DisplayName("setB() success")
        void setBSuccess() {
            int a=3, b=3, c=3;
            assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);triangle.setB(4);},"Value must be greater than 0.");
        }

        @Test
        @DisplayName("setC() success")
        void setCSuccess() {
            int a=3, b=3, c=3;
            assertDoesNotThrow(()->{Triangle triangle = new Triangle(a,b,c);triangle.setC(4);},"Value must be greater than 0.");
        }

        @Test
        @DisplayName("setA() fail caused by a = 0")
        void setAFailCausedBy0() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setA(0);}).getMessage());
        }

        @Test
        @DisplayName("setA() fail caused by negative value")
        void setAFailCausedByNegative() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setA(-3);}).getMessage());
        }

        @Test
        @DisplayName("setB() fail caused by a = 0")
        void setBFailCausedBy0() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setB(0);}).getMessage());
        }

        @Test
        @DisplayName("setB() fail caused by negative value")
        void setBFailCausedByNegative() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setB(-3);}).getMessage());
        }

        @Test
        @DisplayName("setC() fail caused by a = 0")
        void setCFailCausedBy0() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setC(0);}).getMessage());
        }

        @Test
        @DisplayName("setC() fail caused by negative value")
        void setCFailCausedByNegative() {
            int a=3, b=3, c=3;
            assertEquals("Value must be greater than 0.", assertThrows(IllegalArgumentException.class, ()->{Triangle triangle = new Triangle(a,b,c);triangle.setC(-3);}).getMessage());
        }
    }
}
