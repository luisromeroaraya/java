package org.example.tu;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*; // we import static to use assertEquals() directly

public class SimpleClassTest {

    @Test
    @DisplayName("Doing a success test")
    void firstTestCalculationSuccess() {
        // ARRANGE
        int a = 3, b=4;
        int result;

        // ACT
        result = a + b;

        // ASSERT
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Doing a fail test")
    void firstTestCalculationFail() {
        // ARRANGE
        int a = 3, b=4;
        int result;

        // ACT
        result = a + b;

        // ASSERT
        assertNotEquals(8, result);
    }

    @Test
    @DisplayName("Testing division by 0 using assertEquals")
    void testDivisionBy0usingEquals() {
        // ARRANGE
        int a = 3, b=0;

        // ACT
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> { int result = a / b; });

        // ASSERT
        assertEquals("division par zéro", exception.getMessage());
    }

    @Test
    @DisplayName("Testing division by 0 using assertThrows")
    void testDivisionBy0usingThrows() {
        // ARRANGE
        int a = 3, b=0;

        // ASSERT
        assertThrows(ArithmeticException.class, () -> { int result = a / b; }); // ACT inside the lambda
    }

    @Test
    @DisplayName("Testing division by 0 using assertInstanceOf")
    void testDivisionBy0usingInstanceOf() {
        // ARRANGE
        int a = 3, b=0;

        // ACT
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> { int result = a / b; });

        // ASSERT
        assertInstanceOf(ArithmeticException.class, exception);
    }
}