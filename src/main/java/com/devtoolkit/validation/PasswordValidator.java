package com.devtoolkit.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * PasswordValidator – evaluates password strength against configurable rules.
 *
 * <p>
 * Default rules (all enforced unless overridden):
 * <ul>
 * <li>Minimum length of 8 characters</li>
 * <li>At least one uppercase letter (A-Z)</li>
 * <li>At least one lowercase letter (a-z)</li>
 * <li>At least one digit (0-9)</li>
 * <li>At least one special character ({@code !@#$%^&*()_+-=[]|,.<>?})</li>
 * </ul>
 * </p>
 *
 * @author DevToolkit Contributors
 * @version 1.0.0
 */
public class PasswordValidator {

    /** Minimum acceptable password length. */
    private static final int MIN_LENGTH = 8;

    /** Characters that count as "special". */
    private static final String SPECIAL_CHARS = "!@#$%^&*()_+\\-=\\[\\]|,.<>?";

    // Prevent instantiation – utility class
    private PasswordValidator() {
    }

    /**
     * Returns {@code true} only when the password satisfies <em>all</em> default
<<<<<<< HEAD
     * rules.
=======
     * rules:
     * minimum 8 characters, at least one uppercase letter, one digit, and one
     * special character.
>>>>>>> e4379ba8824c71d9976e0792ee3cd7d45b5db36b
     *
     * @param password the password to validate; may be {@code null}
     * @return {@code true} if the password is strong
     */
    public static boolean isStrong(String password) {
<<<<<<< HEAD
        // Improved password validation logic
        return validate(password).isEmpty();
=======

        if (password == null || password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c))
                hasUpper = true;

            else if (Character.isDigit(c))
                hasDigit = true;

            else if (!Character.isLetterOrDigit(c))
                hasSpecial = true;
        }

        return hasUpper && hasDigit && hasSpecial;
>>>>>>> e4379ba8824c71d9976e0792ee3cd7d45b5db36b
    }

    /**
     * Validates the password and returns a list of human-readable failure messages.
     * An empty list means the password passed all checks.
     *
     * @param password the password to validate; may be {@code null}
     * @return an unmodifiable list of violation messages (empty → valid)
     */
    public static List<String> validate(String password) {
        List<String> violations = new ArrayList<>();

        if (password == null || password.isEmpty()) {
            violations.add("Password must not be null or empty.");
            return List.copyOf(violations);
        }

        if (password.length() < MIN_LENGTH) {
            violations.add("Password must be at least " + MIN_LENGTH + " characters long. "
                    + "Current length: " + password.length() + ".");
        }

        if (!password.matches(".*[A-Z].*")) {
            violations.add("Password must contain at least one uppercase letter (A-Z).");
        }

        if (!password.matches(".*[a-z].*")) {
            violations.add("Password must contain at least one lowercase letter (a-z).");
        }

        if (!password.matches(".*[0-9].*")) {
            violations.add("Password must contain at least one digit (0-9).");
        }

        if (!password.matches(".*[" + SPECIAL_CHARS + "].*")) {
            violations.add("Password must contain at least one special character (!@#$%^&*...).");
        }

        return List.copyOf(violations);
    }

    /**
     * Returns a short strength label for the given password.
     *
     * <ul>
     * <li><strong>WEAK</strong> – more than 2 violations</li>
     * <li><strong>MODERATE</strong> – 1–2 violations</li>
     * <li><strong>STRONG</strong> – no violations</li>
     * </ul>
     *
     * @param password the password to rate; may be {@code null}
     * @return strength label string
     */
    public static String strengthLabel(String password) {
        int violations = validate(password).size();
        if (violations == 0)
            return "STRONG";
        if (violations <= 2)
            return "MODERATE";
        return "WEAK";
    }
}
