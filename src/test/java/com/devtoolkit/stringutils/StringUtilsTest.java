package com.devtoolkit.stringutils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link StringUtils}.
 */
@DisplayName("StringUtils Tests")
class StringUtilsTest {

    // ------------------------------------------------------------------
    // reverse()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("reverse – basic word")
    void reverse_basicWord() {
        assertEquals("olleH", StringUtils.reverse("Hello"));
    }

    @Test
    @DisplayName("reverse – empty string returns empty string")
    void reverse_emptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    @DisplayName("reverse – single character")
    void reverse_singleChar() {
        assertEquals("A", StringUtils.reverse("A"));
    }

    @Test
    @DisplayName("reverse – null throws IllegalArgumentException")
    void reverse_null() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.reverse(null));
    }

    // ------------------------------------------------------------------
    // isPalindrome()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("isPalindrome – 'racecar' is a palindrome")
    void isPalindrome_racecar() {
        assertTrue(StringUtils.isPalindrome("racecar"));
    }

    @Test
    @DisplayName("isPalindrome – 'A man a plan a canal Panama' ignoring case & spaces")
    void isPalindrome_sentence() {
        assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    @DisplayName("isPalindrome – 'hello' is not a palindrome")
    void isPalindrome_hello() {
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    @DisplayName("isPalindrome – empty string is palindrome")
    void isPalindrome_empty() {
        assertTrue(StringUtils.isPalindrome(""));
    }

    @Test
    @DisplayName("isPalindrome – null throws IllegalArgumentException")
    void isPalindrome_null() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.isPalindrome(null));
    }

    // ------------------------------------------------------------------
    // removeExtraSpaces()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("removeExtraSpaces – collapses multiple spaces")
    void removeExtraSpaces_multipleSpaces() {
        assertEquals("Hello World", StringUtils.removeExtraSpaces("Hello   World"));
    }

    @Test
    @DisplayName("removeExtraSpaces – trims leading and trailing spaces")
    void removeExtraSpaces_leadingTrailing() {
        assertEquals("Hello World", StringUtils.removeExtraSpaces("  Hello World  "));
    }

    @Test
    @DisplayName("removeExtraSpaces – empty string remains empty")
    void removeExtraSpaces_empty() {
        assertEquals("", StringUtils.removeExtraSpaces(""));
    }

    @Test
    @DisplayName("removeExtraSpaces – null throws IllegalArgumentException")
    void removeExtraSpaces_null() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.removeExtraSpaces(null));
    }

    // ------------------------------------------------------------------
    // wordCount()
    // ------------------------------------------------------------------

    @Test
    @DisplayName("wordCount – three-word sentence")
    void wordCount_threeWords() {
        assertEquals(3, StringUtils.wordCount("Hello World Java"));
    }

    @Test
    @DisplayName("wordCount – blank string returns 0")
    void wordCount_blank() {
        assertEquals(0, StringUtils.wordCount("   "));
    }
}
