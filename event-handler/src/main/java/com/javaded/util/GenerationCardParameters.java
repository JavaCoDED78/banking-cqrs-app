package com.javaded.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class GenerationCardParameters {

    String CARD_NUMBER_PATTERN = "%04d%04d%04d%04d";
    String CARD_DATE_PATTERN = "MM/yy";

    public String generateCvv() {
        return String.valueOf(100 + (int) (Math.random() * 899));
    }

    public String generateDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = currentDate.plusYears(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CARD_DATE_PATTERN);
        return expirationDate.format(formatter);
    }

    public String generateNumber() {
        return String.format(
                CARD_NUMBER_PATTERN,
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999),
                1000 + (int) (Math.random() * 8999)
        );
    }
}
