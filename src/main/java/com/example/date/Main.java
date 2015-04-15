package com.example.date;

import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rinat Zalyaletdinov
 */
@SuppressWarnings("unused")
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.go();
    }

    private void go() {
        timeUnitTest();
    }

    private void showLengthOfMonth() {
        YearMonth date = YearMonth.now();
        LOGGER.info(date.lengthOfMonth());
    }

    private void dateOverlapping() {
        LocalDate date1 = LocalDate.of(2015, Calendar.APRIL, 13);
        LocalDate date2 = LocalDate.of(2015, Calendar.APRIL, 14);
        LOGGER.info(date1.isBefore(date2));
    }

    private void timeUnitTest() {
        LOGGER.info(String.format("Minutes in hour: %d", TimeUnit.HOURS.toMinutes(1)));
    }

}
