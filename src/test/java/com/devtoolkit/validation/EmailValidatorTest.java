package com.devtoolkit.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link EmailValidator}.
 */
@DisplayName("EmailValidator Tests")
class EmailValidatorTest {

    // ------------------------------------------------------------------
    // isValid()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("isValid – standard email is valid")
    void isValid_standard() {
        assertTrue(EmailValidator.isValid("user@example.com"));
    }

    @Test
    @DisplayName("isValid – email with subdomain")
    void isValid_subdomain() {
        assertTrue(EmailValidator.isValid("user@mail.example.co.in"));
    }

    @Test
    @DisplayName("isValid – email with plus tag")
    void isValid_plusTag() {
        assertTrue(EmailValidator.isValid("user+tag@example.org"));
    }

    @Test
    @DisplayName("isValid – email with dots in local part")
    void isValid_dotsLocal() {
        assertTrue(EmailValidator.isValid("john.doe@example.com"));
    }

    @Test
    @DisplayName("isValid – null returns false")
    void isValid_null() {
        assertFalse(EmailValidator.isValid(null));
    }

    @Test
    @DisplayName("isValid – blank string returns false")
    void isValid_blank() {
        assertFalse(EmailValidator.isValid("   "));
    }

    @Test
    @DisplayName("isValid – missing @ symbol returns false")
    void isValid_missingAt() {
        assertFalse(EmailValidator.isValid("userexample.com"));
    }

    @Test
    @DisplayName("isValid – missing domain returns false")
    void isValid_missingDomain() {
        assertFalse(EmailValidator.isValid("user@"));
    }

    @Test
    @DisplayName("isValid – double @ symbol returns false")
    void isValid_doubleAt() {
        assertFalse(EmailValidator.isValid("user@@example.com"));
    }

    @Test
    @DisplayName("isValid – no TLD returns false")
    void isValid_noTld() {
        assertFalse(EmailValidator.isValid("user@example"));
    }

    // ------------------------------------------------------------------
    // extractDomain() / extractLocalPart()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("extractDomain – returns correct domain")
    void extractDomain_valid() {
        assertEquals("example.com", EmailValidator.extractDomain("user@example.com"));
    }

    @Test
    @DisplayName("extractLocalPart – returns correct local part")
    void extractLocalPart_valid() {
        assertEquals("john.doe", EmailValidator.extractLocalPart("john.doe@example.com"));
    }

    @Test
    @DisplayName("extractDomain – invalid email throws IllegalArgumentException")
    void extractDomain_invalid() {
        assertThrows(IllegalArgumentException.class, () -> EmailValidator.extractDomain("not-an-email"));
    }
}
