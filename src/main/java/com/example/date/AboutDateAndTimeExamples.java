package com.example.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class AboutDateAndTimeExamples {
    public static void main(String[] args) throws Exception {
        printDelimeter();
        printOffsetDateTimeWithUTCtz();
//        printDelimeter();
//        printMaxDateValue();
//        printDelimeter();
//        testSunday();
//        printDelimeter();
//        testCalendarMs();
//        printDelimeter();
//        testFormat();
//        printDelimeter();
//        testTzMoscow();
//        printDelimeter();
//        testTzParis();
//        printDelimeter();
//        testGmt5();
//        printDelimeter();
//        testWinterTime();
//        printDelimeter();
//        testSummerTime();
//        printDelimeter();
//        testMissing();
//        printDelimeter();
//        testWinterDay();
//        printDelimeter();
//        testSummerDay();
//        printDelimeter();
//        testSqlTime();
//        printDelimeter();
//        testLeapSecond1();
//        printDelimeter();
//        testLeapSecond2();
    }

    private static void printOffsetDateTimeWithUTCtz() {
        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(utc);
    }

    private static void printMaxDateValue() {
        Date theEnd = new Date(Long.MAX_VALUE);

        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String text = dateFormat.format(theEnd);

        System.out.println(text);
    }

    private static void testSunday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2016, Calendar.JANUARY, 5, 12, 30, 0);
        calendar.add(Calendar.DAY_OF_YEAR, -2);

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
    }

    private static void testCalendarMs() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        Calendar calendar = Calendar.getInstance(tz);
        calendar.setLenient(false);

        calendar.set(2016, Calendar.APRIL, 20, 12, 0, 0);
        System.out.println(calendar.getTimeInMillis());

        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTimeInMillis());
    }

    private static void testFormat() throws ParseException {
        TimeZone tz = TimeZone.getTimeZone(/*"Europe/Moscow"*/"Asia/Yekaterinburg");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Date moment = dateFormat.parse("2005-03-27 01:30:00");
        System.out.println(moment + ":" + "2005-03-27 01:30:00".equals(dateFormat.format(moment)));
    }

    private static void testTzMoscow() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow"/*"Asia/Yekaterinburg"*/);

        System.out.println(tz.getRawOffset());
        System.out.println(tz.getOffset(System.currentTimeMillis()));
        System.out.println(tz.useDaylightTime());

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.ENGLISH));

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.FRENCH));
    }

    private static void testTzParis() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Paris");

        System.out.println(tz.getRawOffset());
        System.out.println(tz.getOffset(System.currentTimeMillis()));
        System.out.println(tz.useDaylightTime());

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.ENGLISH));

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.FRENCH));
    }

    private static void testGmt5() {
        TimeZone tz = TimeZone.getTimeZone("GMT+5");

        System.out.println(tz.getRawOffset());
        System.out.println(tz.getOffset(System.currentTimeMillis()));
        System.out.println(tz.useDaylightTime());

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.ENGLISH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.ENGLISH));

        System.out.println(tz.getDisplayName(false, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(false, TimeZone.SHORT, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.LONG, Locale.FRENCH));
        System.out.println(tz.getDisplayName(true, TimeZone.SHORT, Locale.FRENCH));
    }

    private static void testWinterTime() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2005, Calendar.OCTOBER, 29, 22, 57, 0);

        for (int i = 0; i < 5; i++) {
            String mark = dateFormat.format(calendar.getTime());
            System.out.printf("%s - %d, %s\n", mark,
                    tz.getOffset(calendar.getTimeInMillis()),
                    tz.inDaylightTime(calendar.getTime()));
            calendar.add(Calendar.MINUTE, +1);
        }
    }

    private static void testSummerTime() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(2005, Calendar.MARCH, 26, 22, 57, 0);

        for (int i = 0; i <= 5; i++) {
            String mark = dateFormat.format(calendar.getTime());
            System.out.printf("%s - %d, %s\n", mark,
                    tz.getOffset(calendar.getTimeInMillis()),
                    tz.inDaylightTime(calendar.getTime()));

            calendar.add(Calendar.MINUTE, +1);
        }
    }

    private static void testMissing() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);

        try {
            Date moment = dateFormat.parse("2005-03-27 02:30:00");
            System.out.println(moment);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void testWinterDay() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(tz);
        calendar.set(2005, Calendar.OCTOBER, 30, 0, 0, 0);

        Date time1 = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, +1);

        Date time2 = calendar.getTime();

        System.out.println(TimeUnit.MILLISECONDS.toHours(time2.getTime() - time1.getTime()));
    }

    private static void testSummerDay() {
        TimeZone tz = TimeZone.getTimeZone("Europe/Moscow");

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(tz);
        calendar.set(2005, Calendar.MARCH, 27, 0, 0, 0);

        Date time1 = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, +1);

        Date time2 = calendar.getTime();

        System.out.println(TimeUnit.MILLISECONDS.toHours(time2.getTime() - time1.getTime()));
    }

    private static void testSqlTime() throws Exception {
        // Предположим что сейчас 2015-01-01 01:00:00 MSK
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        calendar.setTimeInMillis(0);
        calendar.set(2015, Calendar.JANUARY, 10, 1, 0, 0);

        long now = calendar.getTimeInMillis();

        // Создаем инстанс java.sql.Time
        java.sql.Time sqlTime = new java.sql.Time(now);
        java.sql.Date sqlDate = new java.sql.Date(now);

        // Теперь выводим значение времени в временной зоне Europe/London
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println("22:00:00".equals(timeFormat.format(sqlTime)));

        // Теперь выводим значение даты в временной зоне Europe/London
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println("2015-01-09".equals(dateFormat.format(sqlDate)));
    }

    private static void testLeapSecond1() {
        TimeZone tz = TimeZone.getTimeZone("UTC");

        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTimeZone(tz);
        calendar.set(2015, Calendar.JUNE, 30, 23, 59, 0);
        Date d1 = calendar.getTime();

        calendar.set(2015, Calendar.JULY, 1, 0, 1, 0);
        Date d2 = calendar.getTime();

        long elapsed = d2.getTime() - d1.getTime();

        System.out.println(TimeUnit.MILLISECONDS.toSeconds(elapsed));
    }

    private static void testLeapSecond2() {
        ZonedDateTime beforeLeap = ZonedDateTime.of(2015, 6, 30, 23, 30, 0, 0, ZoneOffset.UTC);
        ZonedDateTime afterLeap = ZonedDateTime.of(2015, 7, 1, 0, 30, 0, 0, ZoneOffset.UTC);

        long elapsed = afterLeap.toInstant().toEpochMilli() - beforeLeap.toInstant().toEpochMilli();

        System.out.println(TimeUnit.MILLISECONDS.toSeconds(elapsed));
    }

    private static void printDelimeter() {
        System.out.println("==============================");
    }
}
