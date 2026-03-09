package com.devtoolkit.stringutils;

/**
 * StringUtils – provides common string manipulation utilities.
 *
 * <p>
 * All methods are stateless and thread-safe.
 * </p>
 *
 * @author DevToolkit Contributors
 * @version 1.0.0
 */
public class StringUtils {

    // Prevent instantiation – utility class
    private StringUtils() {
    }

    /**
     * Reverses the characters of the given string.
     *
     * @param input the string to reverse; may be {@code null}
     * @return the reversed string, or {@code null} if {@code input} is {@code null}
     */
    public static String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    /**
     * Checks whether the given string is a palindrome.
     * The comparison is case-insensitive and ignores non-alphanumeric characters.
     *
     * @param input the string to check; must not be {@code null}
     * @return {@code true} if the string is a palindrome, {@code false} otherwise
     * @throws IllegalArgumentException if {@code input} is {@code null}
     */
    public static boolean isPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string must not be null.");
        }
        // Normalise: lowercase and keep only alphanumeric characters
        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    /**
     * Removes leading, trailing, and consecutive embedded whitespace from the given
     * string,
     * collapsing multiple spaces between words into a single space.
     *
     * @param input the string to normalise; must not be {@code null}
     * @return the normalised string
     * @throws IllegalArgumentException if {@code input} is {@code null}
     */
    public static String removeExtraSpaces(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string must not be null.");
        }
        return input.trim().replaceAll("\\s+", " ");
    }

    /**
     * Counts the number of words in the given string.
     * Words are separated by one or more whitespace characters.
     *
     * @param input the string to count words in; must not be {@code null}
     * @return word count (0 for blank input)
     */
    public static int wordCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input string must not be null.");
        }
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }

    /**
     * Checks whether the given string is blank (null, empty, or whitespace-only).
     *
     * @param input the string to check
     * @return {@code true} if blank
     */
    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
