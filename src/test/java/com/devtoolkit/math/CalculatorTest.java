package com.devtoolkit.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Calculator}.
 */
@DisplayName("Calculator Tests")
class CalculatorTest {

    private static final double DELTA = 1e-9;

    @Test
    @DisplayName("add – positive numbers")
    void add_positive() {
        assertEquals(7.0, Calculator.add(3, 4), DELTA);
    }

    @Test
    @DisplayName("add – negative numbers")
    void add_negative() {
        assertEquals(-1.0, Calculator.add(-3, 2), DELTA);
    }

    @Test
    @DisplayName("subtract – positive result")
    void subtract_positive() {
        assertEquals(3.0, Calculator.subtract(7, 4), DELTA);
    }

    @Test
    @DisplayName("subtract – negative result")
    void subtract_negative() {
        assertEquals(-2.0, Calculator.subtract(3, 5), DELTA);
    }

    @Test
    @DisplayName("multiply – two positives")
    void multiply_positive() {
        assertEquals(12.0, Calculator.multiply(3, 4), DELTA);
    }

    @Test
    @DisplayName("multiply – positive and negative")
    void multiply_negativeResult() {
        assertEquals(-12.0, Calculator.multiply(-3, 4), DELTA);
    }

    @Test
    @DisplayName("multiply – by zero returns zero")
    void multiply_byZero() {
        assertEquals(0.0, Calculator.multiply(100, 0), DELTA);
    }

    @Test
    @DisplayName("divide – exact division")
    void divide_exact() {
        assertEquals(2.5, Calculator.divide(5, 2), DELTA);
    }

    @Test
    @DisplayName("divide – by zero throws ArithmeticException")
    void divide_byZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }

    @Test
    @DisplayName("power – positive exponent")
    void power_positive() {
        assertEquals(8.0, Calculator.power(2, 3), DELTA);
    }

    @Test
    @DisplayName("power – zero exponent returns 1")
    void power_zeroExponent() {
        assertEquals(1.0, Calculator.power(5, 0), DELTA);
    }

    @Test
    @DisplayName("sqrt – perfect square")
    void sqrt_perfectSquare() {
        assertEquals(4.0, Calculator.sqrt(16), DELTA);
    }

    @Test
    @DisplayName("sqrt – negative number throws IllegalArgumentException")
    void sqrt_negative() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.sqrt(-1));
    }

    @Test
    @DisplayName("abs – negative number")
    void abs_negative() {
        assertEquals(5.0, Calculator.abs(-5), DELTA);
    }

    @Test
    @DisplayName("abs – positive number unchanged")
    void abs_positive() {
        assertEquals(7.3, Calculator.abs(7.3), DELTA);
    }
}
