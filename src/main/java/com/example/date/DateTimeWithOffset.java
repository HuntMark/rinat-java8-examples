package com.example.date;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeWithOffset {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
        LocalDateTime dateTime2 = LocalDateTime.now(ZoneId.of("Asia/Tashkent"));
        System.out.println("Moscow: " + dateTime1 + "\n" + "Tashkent: " + dateTime2);
    }
}
