package com.example.date_time_api;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class MainYearMontParse {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");
        String time = "1705";
        TemporalAccessor parsed = formatter.parse(time);
        System.out.println(parsed.get(ChronoField.YEAR));
        System.out.println(parsed.get(ChronoField.MONTH_OF_YEAR));
    }
}
