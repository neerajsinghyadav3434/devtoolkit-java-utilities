package com.devtoolkit.validation;

import java.util.regex.Pattern;

/**
 * EmailValidator – validates whether a string conforms to a standard email address format.
 *
 * <p>Uses a well-tested RFC-5321-inspired regular expression for validation.
 * This utility does <em>not</em> perform DNS or SMTP reachability checks.</p>
 *
 * @author  DevToolkit Contributors
 * @version 1.0.0
 */
public class EmailValidator {

    /**
     * RFC-5321-inspired email regex.
     * Supports common formats: local@domain.tld, user+tag@sub.domain.co
     */
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$"
    );

    // Prevent instantiation – utility class
    private EmailValidator() {}

    /**
     * Returns {@code true} if the supplied string is a syntactically valid email address.
     *
     * @param email the email address to validate; may be {@code null}
     * @return {@code true} if valid, {@code false} if {@code null}, blank, or malformed
     */
    public static boolean isValid(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    /**
     * Extracts the domain part of a valid email address.
     *
     * @param email a syntactically valid email address; must not be {@code null}
     * @return the domain portion (e.g. {@code "example.com"})
     * @throws IllegalArgumentException if the email is invalid or {@code null}
     */
    public static String extractDomain(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Cannot extract domain: invalid email address → " + email);
        }
        return email.substring(email.indexOf('@') + 1);
    }

    /**
     * Extracts the local (username) part of a valid email address.
     *
     * @param email a syntactically valid email address; must not be {@code null}
     * @return the local portion (e.g. {@code "john.doe"})
     * @throws IllegalArgumentException if the email is invalid or {@code null}
     */
    public static String extractLocalPart(String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Cannot extract local part: invalid email address → " + email);
        }
        return email.substring(0, email.indexOf('@'));
    }
}
