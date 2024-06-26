package com.javaded.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class GenerationCardParameters {

    private static String CARD_NUMBER_PATTERN = "%04d%04d%04d%04d";
    private static String CARD_DATE_PATTERN = "MM/yy";

    private GenerationCardParameters() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String generateCvv() {
        return String.valueOf(100 + (int) (Math.random() * 899));
    }

    public static String generateDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusYears(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CARD_DATE_PATTERN);
        return expirationDate.format(formatter);
    }

    public static String generateNumber() {
        return String.format(
                CARD_NUMBER_PATTERN,
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999)
        );
    }
}
