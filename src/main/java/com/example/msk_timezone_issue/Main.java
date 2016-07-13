package com.example.msk_timezone_issue;

import java.time.OffsetDateTime;
import java.time.ZoneId;

public class Main {
  public static void main(String[] args) {
    OffsetDateTime local = OffsetDateTime.now();
    OffsetDateTime moscow = OffsetDateTime.now(ZoneId.of("Europe/Moscow"));
    System.out.println("Local time: " + local);
    System.out.println("Moscow time: " + moscow);
  }
}
