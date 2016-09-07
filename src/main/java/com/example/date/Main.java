package com.example.date;

import org.apache.log4j.Logger;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    Main main = new Main();
    main.go();
  }

  private void go() {
    printLocalDateTime();
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

  private void weekDays() {
    LocalDate firstOfWeek = LocalDate.now().with(ChronoField.DAY_OF_WEEK, 1);
    LOGGER.info(firstOfWeek + " : " + firstOfWeek.getDayOfWeek());
  }

  private void monthDays() {
    LocalDate firstOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    LOGGER.info(firstOfMonth + " : " + firstOfMonth.getDayOfWeek());
  }

  private void printLocalDateTime() {
    LocalDateTime now = LocalDateTime.now();
    LOGGER.info(now.toInstant(ZoneOffset.UTC));
  }
}
