package com.example.date_time_api;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
  public static void main(String[] args) {
    System.out.println(Instant.now());
    System.out.println(LocalDateTime.now());
    System.out.println(DayOfWeek.TUESDAY.getDisplayName(TextStyle.NARROW, new Locale("ru")));
  }
}
