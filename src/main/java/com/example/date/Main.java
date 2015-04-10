package com.example.date;

import org.apache.log4j.Logger;

import java.time.YearMonth;

/**
 * Created by Rinat Zalyaletdinov
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        YearMonth date = YearMonth.now();
        LOGGER.info(date.lengthOfMonth());
    }

}
