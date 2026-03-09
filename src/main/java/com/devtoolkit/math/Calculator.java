package com.devtoolkit.math;

/**
 * Calculator – provides basic arithmetic operations with proper error handling.
 *
 * <p>
 * All methods operate on {@code double} values for maximum flexibility.
 * The class is stateless and safe for use from multiple threads.
 * </p>
 *
 * @author DevToolkit Contributors
 * @version 1.0.0
 */
public class Calculator {

    // Prevent instantiation – utility class
    private Calculator() {
    }

    /**
     * Adds two numbers.
     *
     * @param a the first operand
     * @param b the second operand
     * @return {@code a + b}
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts {@code b} from {@code a}.
     *
     * @param a the minuend
     * @param b the subtrahend
     * @return {@code a - b}
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a the first factor
     * @param b the second factor
     * @return {@code a * b}
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides {@code a} by {@code b}.
     *
     * @param a the dividend
     * @param b the divisor; must not be {@code 0}
     * @return {@code a / b}
     * @throws ArithmeticException if {@code b} is zero
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    /**
     * Returns the modulo (remainder) of {@code a} divided by {@code b}.
     *
     * @param a the dividend
     * @param b the divisor; must not be {@code 0}
     * @return {@code a % b}
     * @throws ArithmeticException if {@code b} is zero
     */
    public static double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero is not allowed.");
        }
        return a % b;
    }

    /**
     * Returns the absolute value of a number.
     *
     * @param a the number
     * @return {@code |a|}
     */
    public static double abs(double a) {
        return Math.abs(a);
    }

    /**
     * Raises {@code base} to the power of {@code exponent}.
     *
     * @param base     the base
     * @param exponent the exponent
     * @return {@code base ^ exponent}
     */
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Returns the square root of a non-negative number.
     *
     * @param a the value; must be {@code >= 0}
     * @return {@code √a}
     * @throws IllegalArgumentException if {@code a} is negative
     */
    public static double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number: " + a);
        }
        return Math.sqrt(a);
    }
}
