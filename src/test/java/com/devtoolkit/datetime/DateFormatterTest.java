package com.devtoolkit.datetime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link DateFormatter}.
 */
@DisplayName("DateFormatter Tests")
class DateFormatterTest {

    @Test
    @DisplayName("format LocalDate – ISO format")
    void format_iso() {
        LocalDate date = LocalDate.of(2026, 3, 10);
        assertEquals("2026-03-10", DateFormatter.format(date, DateFormatter.FORMAT_ISO));
    }

    @Test
    @DisplayName("format LocalDate – dd/MM/yyyy format")
    void format_ddMMyyyy() {
        LocalDate date = LocalDate.of(2026, 3, 10);
        assertEquals("10/03/2026", DateFormatter.format(date, DateFormatter.FORMAT_DD_MM_YYYY));
    }

    @Test
    @DisplayName("format LocalDate – dd-MMM-yyyy format")
    void format_ddMMMMyyyy() {
        LocalDate date = LocalDate.of(2026, 3, 10);
        assertEquals("10-Mar-2026", DateFormatter.format(date, DateFormatter.FORMAT_DD_MMM_YYYY));
    }

    @Test
    @DisplayName("format – null date throws IllegalArgumentException")
    void format_nullDate() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.format((LocalDate) null, DateFormatter.FORMAT_ISO));
    }

    @Test
    @DisplayName("format – null pattern throws IllegalArgumentException")
    void format_nullPattern() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.format(LocalDate.now(), null));
    }

    @Test
    @DisplayName("convert – dd/MM/yyyy to ISO")
    void convert_ddMMyyyyToIso() {
        String result = DateFormatter.convert("10/03/2026",
                DateFormatter.FORMAT_DD_MM_YYYY,
                DateFormatter.FORMAT_ISO);
        assertEquals("2026-03-10", result);
    }

    @Test
    @DisplayName("convert – ISO to US format")
    void convert_isoToUs() {
        String result = DateFormatter.convert("2026-03-10",
                DateFormatter.FORMAT_ISO,
                DateFormatter.FORMAT_MM_DD_YYYY);
        assertEquals("03/10/2026", result);
    }

    @Test
    @DisplayName("convert – invalid date string throws IllegalArgumentException")
    void convert_invalidDate() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.convert("not-a-date",
                        DateFormatter.FORMAT_ISO,
                        DateFormatter.FORMAT_DD_MM_YYYY));
    }

    @Test
    @DisplayName("parse – valid ISO date string")
    void parse_validIso() {
        LocalDate expected = LocalDate.of(2026, 1, 15);
        assertEquals(expected, DateFormatter.parse("2026-01-15", DateFormatter.FORMAT_ISO));
    }

    @Test
    @DisplayName("formatToday – returns non-null non-blank string")
    void formatToday_returnsValue() {
        String result = DateFormatter.formatToday(DateFormatter.FORMAT_ISO);
        assertNotNull(result);
        assertFalse(result.isBlank());
    }
}
