package org.example.tu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {
    enum DayWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    @ParameterizedTest
    @ValueSource(strings = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"})
    void isPresentInEnum(String day) {
        assertNotNull(DayWeek.valueOf(day.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(DayWeek.class)
    void isPresent(DayWeek day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(names = {"MONDAY", "THURSDAY"})
    void isIncludedInEnum(DayWeek day) {
        assertTrue(EnumSet.of(DayWeek.MONDAY, DayWeek.THURSDAY).contains(day));
    }

    static Stream<String> supplier() {
        return Stream.of("apple", "pear", "banana");
    }

    @ParameterizedTest
    @MethodSource("supplier")
    void isInjectedByMethod(String string) {
        assertTrue(string.endsWith("e"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/days.csv", delimiter = '|', numLinesToSkip = 1)
    void isInjectedByFile(String day, int index) {
        assertNotNull(day);
        assertNotEquals(-1, index);
    }

}
