package com.devtoolkit.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link PasswordValidator}.
 */
@DisplayName("PasswordValidator Tests")
class PasswordValidatorTest {

    @Test
    @DisplayName("isStrong – strong password passes all rules")
    void isStrong_valid() {
        assertTrue(PasswordValidator.isStrong("SecureP@ss1"));
    }

    @Test
    @DisplayName("isStrong – too short password fails")
    void isStrong_tooShort() {
        assertFalse(PasswordValidator.isStrong("Ab1!"));
    }

    @Test
    @DisplayName("isStrong – missing uppercase fails")
    void isStrong_noUppercase() {
        assertFalse(PasswordValidator.isStrong("securepass1!"));
    }

    @Test
    @DisplayName("isStrong – missing digit fails")
    void isStrong_noDigit() {
        assertFalse(PasswordValidator.isStrong("SecurePass!"));
    }

    @Test
    @DisplayName("isStrong – missing special character fails")
    void isStrong_noSpecial() {
        assertFalse(PasswordValidator.isStrong("SecurePass1"));
    }

    @Test
    @DisplayName("isStrong – null returns false")
    void isStrong_null() {
        assertFalse(PasswordValidator.isStrong(null));
    }

    @Test
    @DisplayName("validate – returns specific violation messages")
    void validate_violations() {
        List<String> violations = PasswordValidator.validate("abc");
        assertFalse(violations.isEmpty());
        // Should mention length
        assertTrue(violations.stream().anyMatch(v -> v.contains("8 characters")));
    }

    @Test
    @DisplayName("validate – strong password returns empty list")
    void validate_noViolations() {
        List<String> violations = PasswordValidator.validate("StrongP@ss9");
        assertTrue(violations.isEmpty());
    }

    @Test
    @DisplayName("strengthLabel – STRONG for valid password")
    void strengthLabel_strong() {
        assertEquals("STRONG", PasswordValidator.strengthLabel("StrongP@ss9"));
    }

    @Test
    @DisplayName("strengthLabel – WEAK for very poor password")
    void strengthLabel_weak() {
        assertEquals("WEAK", PasswordValidator.strengthLabel("abc"));
    }
}
