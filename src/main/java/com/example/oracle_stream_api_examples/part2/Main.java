package com.example.oracle_stream_api_examples.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Rinat Zalyaletdinov.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        listing2();
        listing7();
    }

    private static void listing2() {
        Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");
        Map<String, Long> letterToCount =
                words.map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .collect(groupingBy(identity(), counting()));
        System.out.println(letterToCount);
    }

    private static void listing7() throws IOException {
        Files.lines(Paths.get("stuff.txt"))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }
}
