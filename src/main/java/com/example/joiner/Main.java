package com.example.joiner;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
  private static final Logger LOGGER = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    LOGGER.info(joiner.toString());
    List<Long> list = new ArrayList<>();
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    for (Long item : list) {
      joiner.add(item.toString());
    }
    LOGGER.info(joiner.toString());
  }
}
