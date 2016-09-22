package com.example.date_time_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String time = "2016-01-01 00:00";
    LocalDateTime date = LocalDateTime.parse(time, formatter);
    date = date.withSecond(0);
    LOGGER.info(date.format(DateTimeFormatter.ISO_DATE_TIME));
  }
}
