package com.devtoolkit.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * DateFormatter – provides date/time formatting and conversion utilities.
 *
 * <p>
 * Wraps the Java 8+ {@link java.time} API in simple helper methods
 * suited for CLI and library use.
 * </p>
 *
 * @author DevToolkit Contributors
 * @version 1.0.0
 */
public class DateFormatter {

    // Prevent instantiation – utility class
    private DateFormatter() {
    }

    // -------------------------------------------------------------------------
    // Common format constants
    // -------------------------------------------------------------------------

    /** {@code dd/MM/yyyy} – common Indian / European style. */
    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

    /** {@code MM/dd/yyyy} – US style. */
    public static final String FORMAT_MM_DD_YYYY = "MM/dd/yyyy";

    /** {@code yyyy-MM-dd} – ISO-8601 standard. */
    public static final String FORMAT_ISO = "yyyy-MM-dd";

    /** {@code dd-MMM-yyyy} – e.g. "10-Mar-2026". */
    public static final String FORMAT_DD_MMM_YYYY = "dd-MMM-yyyy";

    /** {@code EEEE, MMMM d, yyyy} – verbose, e.g. "Tuesday, March 10, 2026". */
    public static final String FORMAT_VERBOSE = "EEEE, MMMM d, yyyy";

    // -------------------------------------------------------------------------
    // Formatting
    // -------------------------------------------------------------------------

    /**
     * Formats today's date using the supplied pattern.
     *
     * @param pattern a {@link DateTimeFormatter} pattern; must not be {@code null}
     * @return formatted date string for today
     */
    public static String formatToday(String pattern) {
        return format(LocalDate.now(), pattern);
    }

    /**
     * Formats a {@link LocalDate} using the supplied pattern.
     *
     * @param date    the date to format; must not be {@code null}
     * @param pattern a {@link DateTimeFormatter} pattern; must not be {@code null}
     * @return the formatted date string
     * @throws IllegalArgumentException if either argument is {@code null} or the
     *                                  pattern is invalid
     */
    public static String format(LocalDate date, String pattern) {
        if (date == null)
            throw new IllegalArgumentException("Date must not be null.");
        if (pattern == null)
            throw new IllegalArgumentException("Pattern must not be null.");
        try {
            return date.format(DateTimeFormatter.ofPattern(pattern));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid date pattern: " + pattern, e);
        }
    }

    /**
     * Formats a {@link LocalDateTime} using the supplied pattern.
     *
     * @param dateTime the date-time to format; must not be {@code null}
     * @param pattern  a {@link DateTimeFormatter} pattern; must not be {@code null}
     * @return the formatted date-time string
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        if (dateTime == null)
            throw new IllegalArgumentException("DateTime must not be null.");
        if (pattern == null)
            throw new IllegalArgumentException("Pattern must not be null.");
        try {
            return dateTime.format(DateTimeFormatter.ofPattern(pattern));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid date-time pattern: " + pattern, e);
        }
    }

    // -------------------------------------------------------------------------
    // Conversion
    // -------------------------------------------------------------------------

    /**
     * Converts a date string from one format to another.
     *
     * @param dateString    the input date string; must not be {@code null}
     * @param sourcePattern the pattern that describes {@code dateString}; must not
     *                      be {@code null}
     * @param targetPattern the desired output pattern; must not be {@code null}
     * @return the re-formatted date string
     * @throws IllegalArgumentException if any argument is {@code null}, a pattern
     *                                  is invalid,
     *                                  or the input cannot be parsed with the
     *                                  source pattern
     */
    public static String convert(String dateString, String sourcePattern, String targetPattern) {
        if (dateString == null)
            throw new IllegalArgumentException("Date string must not be null.");
        if (sourcePattern == null)
            throw new IllegalArgumentException("Source pattern must not be null.");
        if (targetPattern == null)
            throw new IllegalArgumentException("Target pattern must not be null.");
        try {
            DateTimeFormatter source = DateTimeFormatter.ofPattern(sourcePattern);
            DateTimeFormatter target = DateTimeFormatter.ofPattern(targetPattern);
            LocalDate parsed = LocalDate.parse(dateString.trim(), source);
            return parsed.format(target);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Cannot parse \"" + dateString + "\" using pattern \"" + sourcePattern + "\".", e);
        }
    }

    /**
     * Parses a date string using the given pattern and returns a {@link LocalDate}.
     *
     * @param dateString the date string to parse; must not be {@code null}
     * @param pattern    the pattern to use for parsing; must not be {@code null}
     * @return the parsed {@link LocalDate}
     * @throws IllegalArgumentException if parsing fails
     */
    public static LocalDate parse(String dateString, String pattern) {
        if (dateString == null)
            throw new IllegalArgumentException("Date string must not be null.");
        if (pattern == null)
            throw new IllegalArgumentException("Pattern must not be null.");
        try {
            return LocalDate.parse(dateString.trim(), DateTimeFormatter.ofPattern(pattern));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Cannot parse \"" + dateString + "\" using pattern \"" + pattern + "\".", e);
        }
    }
}
