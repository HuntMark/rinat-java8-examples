package com.example.date_time_api;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class MainYearMontParse {

    // https://stackoverflow.com/questions/29644949/parsing-date-without-month-using-datetimeformatter
    public static void main(String[] args) {
        DateTimeFormatter f = new DateTimeFormatterBuilder()
                .appendPattern("yyMM")
                .parseDefaulting(DAY_OF_MONTH, 1)
                .toFormatter();
        LocalDate date = LocalDate.parse("1705", f);
        System.out.println(date);
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getMonth());
        System.out.println(date.getYear());

        System.out.println(LocalDate.now().withDayOfMonth(1));

        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");
        String time = "1705";
        TemporalAccessor parsed = formatter.parse(time);
        System.out.println(parsed.get(ChronoField.YEAR));
        System.out.println(parsed.get(ChronoField.MONTH_OF_YEAR));
        */
    }
}
