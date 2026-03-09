package com.devtoolkit.app;

import com.devtoolkit.datetime.DateFormatter;
import com.devtoolkit.math.Calculator;
import com.devtoolkit.stringutils.StringUtils;
import com.devtoolkit.validation.EmailValidator;
import com.devtoolkit.validation.PasswordValidator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Main – entry point for the DevToolkit CLI.
 *
 * <p>
 * Presents an interactive menu that lets users exercise each utility
 * module without writing any code.
 * </p>
 *
 * @author DevToolkit Contributors
 * @version 1.0.0
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        printBanner();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> handleReverseString();
                case 2 -> handlePalindrome();
                case 3 -> handleRemoveSpaces();
                case 4 -> handleEmailValidator();
                case 5 -> handlePasswordValidator();
                case 6 -> handleCalculator();
                case 7 -> handleDateFormatter();
                case 0 -> {
                    System.out.println("\n  👋  Thank you for using DevToolkit. Goodbye!\n");
                    running = false;
                }
                default -> System.out.println("\n  ⚠️  Invalid choice. Please enter a number from the menu.\n");
            }
        }

        SCANNER.close();
    }

    // -------------------------------------------------------------------------
    // Menu rendering
    // -------------------------------------------------------------------------

    private static void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║        DevToolkit – Java Utility CLI     ║");
        System.out.println("  ║           v1.0.0  |  MIT License         ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("  ┌─────────────────────────────────────────┐");
        System.out.println("  │              MAIN MENU                  │");
        System.out.println("  ├─────────────────────────────────────────┤");
        System.out.println("  │  1. Reverse a String                    │");
        System.out.println("  │  2. Check Palindrome                    │");
        System.out.println("  │  3. Remove Extra Spaces                 │");
        System.out.println("  │  4. Validate Email Address              │");
        System.out.println("  │  5. Password Strength Check             │");
        System.out.println("  │  6. Calculator                          │");
        System.out.println("  │  7. Date Format Converter               │");
        System.out.println("  │  0. Exit                                │");
        System.out.println("  └─────────────────────────────────────────┘");
    }

    // -------------------------------------------------------------------------
    // Handler methods
    // -------------------------------------------------------------------------

    private static void handleReverseString() {
        System.out.println("\n  ── Reverse a String ──");
        String input = readLine("  Enter a string: ");
        System.out.println("  ✅  Reversed: " + StringUtils.reverse(input));
        System.out.println();
    }

    private static void handlePalindrome() {
        System.out.println("\n  ── Palindrome Check ──");
        String input = readLine("  Enter a string: ");
        boolean result = StringUtils.isPalindrome(input);
        String label = result ? "✅  YES, it is a palindrome." : "❌  NO, it is not a palindrome.";
        System.out.println("  " + label);
        System.out.println();
    }

    private static void handleRemoveSpaces() {
        System.out.println("\n  ── Remove Extra Spaces ──");
        String input = readLine("  Enter a string: ");
        System.out.println("  ✅  Cleaned: \"" + StringUtils.removeExtraSpaces(input) + "\"");
        System.out.println();
    }

    private static void handleEmailValidator() {
        System.out.println("\n  ── Email Validator ──");
        String email = readLine("  Enter an email address: ");
        if (EmailValidator.isValid(email)) {
            System.out.println("  ✅  Valid email.");
            System.out.println("      Local part : " + EmailValidator.extractLocalPart(email));
            System.out.println("      Domain     : " + EmailValidator.extractDomain(email));
        } else {
            System.out.println("  ❌  Invalid email address.");
        }
        System.out.println();
    }

    private static void handlePasswordValidator() {
        System.out.println("\n  ── Password Strength Check ──");
        String password = readLine("  Enter a password: ");
        String label = PasswordValidator.strengthLabel(password);
        List<String> violations = PasswordValidator.validate(password);

        System.out.println("  Strength : " + strengthEmoji(label) + "  " + label);
        if (!violations.isEmpty()) {
            System.out.println("  Issues found:");
            violations.forEach(v -> System.out.println("    • " + v));
        } else {
            System.out.println("  ✅  Password meets all requirements.");
        }
        System.out.println();
    }

    private static void handleCalculator() {
        System.out.println("\n  ── Calculator ──");
        System.out.println("  Operations:  1) Add  2) Subtract  3) Multiply  4) Divide  5) Power  6) Square Root");
        int op = readInt("  Select operation: ");

        if (op == 6) {
            // Unary operation
            double a = readDouble("  Enter number: ");
            try {
                System.out.printf("  ✅  √%.4f = %.4f%n%n", a, Calculator.sqrt(a));
            } catch (IllegalArgumentException e) {
                System.out.println("  ❌  " + e.getMessage());
            }
            return;
        }

        double a = readDouble("  Enter first number : ");
        double b = readDouble("  Enter second number: ");

        try {
            double result = switch (op) {
                case 1 -> Calculator.add(a, b);
                case 2 -> Calculator.subtract(a, b);
                case 3 -> Calculator.multiply(a, b);
                case 4 -> Calculator.divide(a, b);
                case 5 -> Calculator.power(a, b);
                default -> throw new IllegalArgumentException("Unknown operation.");
            };
            System.out.printf("  ✅  Result = %.4f%n%n", result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("  ❌  Error: " + e.getMessage() + "\n");
        }
    }

    private static void handleDateFormatter() {
        System.out.println("\n  ── Date Format Converter ──");
        System.out.println("  1) Format today's date");
        System.out.println("  2) Convert between two formats");
        int op = readInt("  Select option: ");

        if (op == 1) {
            printDatePatternMenu();
            String pattern = selectDatePattern(readInt("  Select pattern: "));
            System.out.println("  ✅  Today's date: " + DateFormatter.formatToday(pattern));
        } else if (op == 2) {
            System.out.println("\n  Source format:");
            printDatePatternMenu();
            String sourcePattern = selectDatePattern(readInt("  Select source pattern: "));
            System.out.println("  Destination format:");
            printDatePatternMenu();
            String targetPattern = selectDatePattern(readInt("  Select target pattern: "));
            String dateStr = readLine("  Enter date (matching source format): ");
            try {
                System.out.println("  ✅  Converted: " + DateFormatter.convert(dateStr, sourcePattern, targetPattern));
            } catch (IllegalArgumentException e) {
                System.out.println("  ❌  " + e.getMessage());
            }
        } else {
            System.out.println("  ⚠️  Invalid option.");
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // Helper methods
    // -------------------------------------------------------------------------

    private static void printDatePatternMenu() {
        System.out.println("    1) dd/MM/yyyy  (e.g. 10/03/2026)");
        System.out.println("    2) MM/dd/yyyy  (e.g. 03/10/2026)");
        System.out.println("    3) yyyy-MM-dd  (ISO 8601)");
        System.out.println("    4) dd-MMM-yyyy (e.g. 10-Mar-2026)");
        System.out.println("    5) EEEE, MMMM d, yyyy (verbose)");
    }

    private static String selectDatePattern(int choice) {
        return switch (choice) {
            case 1 -> DateFormatter.FORMAT_DD_MM_YYYY;
            case 2 -> DateFormatter.FORMAT_MM_DD_YYYY;
            case 3 -> DateFormatter.FORMAT_ISO;
            case 4 -> DateFormatter.FORMAT_DD_MMM_YYYY;
            case 5 -> DateFormatter.FORMAT_VERBOSE;
            default -> DateFormatter.FORMAT_ISO;
        };
    }

    private static String strengthEmoji(String label) {
        return switch (label) {
            case "STRONG" -> "💪";
            case "MODERATE" -> "⚠️";
            default -> "❌";
        };
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = SCANNER.nextInt();
                SCANNER.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                System.out.println("  ⚠️  Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = SCANNER.nextDouble();
                SCANNER.nextLine();
                return value;
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                System.out.println("  ⚠️  Please enter a valid number.");
            }
        }
    }
}
