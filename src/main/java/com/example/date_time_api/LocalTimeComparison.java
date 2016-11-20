package com.example.date_time_api;

import java.time.LocalTime;

public class LocalTimeComparison {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(10, 0);
        LocalTime time2 = LocalTime.of(9, 59);

        System.out.println(time1.compareTo(time2));
    }
}
