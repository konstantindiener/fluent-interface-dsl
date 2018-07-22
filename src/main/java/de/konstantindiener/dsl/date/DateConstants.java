package de.konstantindiener.dsl.date;

import java.time.LocalDate;

public class DateConstants {

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDate infinity() {
        return LocalDate.MAX;
    }
}