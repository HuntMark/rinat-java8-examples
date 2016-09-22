package com.example.date_time_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class Main {
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
    OffsetDateTime now = OffsetDateTime.now();
    LOGGER.info(now.toString());
    TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
    ZoneId zoneId = ZoneId.of("Europe/Moscow");
    now = OffsetDateTime.of(now.toLocalDateTime(), zoneId.getRules().getOffset(LocalDateTime.now()));
    LOGGER.info(now.toString());
  }
}
