package com.example.stream_api_examples;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    private static void print(String string) {
        System.out.print(string);
    }

    private static void println() {
        println("");
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void delimiter() {
        println("==============================");
    }

    private void run() throws IOException {
        delimiter();
        printSumOdd();
        delimiter();
        printStreamBuilding();
    }

    private void printSumOdd() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer sum = 0;

        for (Integer number : numbers) {
            if (number % 2 != 0) {
                sum += number;
            }
        }

        println(String.format("Plain way sum printing: %d", sum));

        sum = numbers.stream().filter(n -> n % 2 != 0).reduce((n1, n2) -> n1 + n2).orElse(0);
        println(String.format("Stream way sum printing: %d", sum));
    }

    private void printStreamBuilding() throws IOException {
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        println(String.format("Build stream from values: %s", streamFromValues.collect(Collectors.toList())));

        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        println(String.format("Build stream from array (1): %s", streamFromArrays.collect(Collectors.toList())));

        streamFromArrays = Stream.of(array);
        println(String.format("Build stream from array (2): %s", streamFromArrays.collect(Collectors.toList())));

        File file = new File("1.tmp");
        file.deleteOnExit();
        PrintWriter out = new PrintWriter(file);
        out.println("a1");
        out.println("a2");
        out.println("a3");
        out.close();

        Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
        println(String.format("Build stream from file: %s", streamFromFiles.collect(Collectors.toList())));

        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        println(String.format("Build stream from collection: %s", streamFromCollection.collect(Collectors.toList())));

        IntStream streamFromString = "123".chars();
        print("Build int stream from string: ");
        streamFromString.forEach((n -> print(n + ", ")));
        println();

        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
        println(String.format("Build stream from builder: %s", streamFromBuilder.collect(Collectors.toList())));

        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
        println(String.format("Build stream from iterate: %s", streamFromIterate.limit(3).collect(Collectors.toList())));

        Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
        println(String.format("Build stream from generate: %s", streamFromGenerate.limit(3).collect(Collectors.toList())));

        Stream<String> streamEmpty = Stream.empty();
        println(String.format("Build empty stream: %s", streamEmpty.collect(Collectors.toList())));

        Stream<String> parallelStream = collection.parallelStream();
        println(String.format("Build parallel stream from collection: %s", parallelStream.collect(Collectors.toList())));
    }
}
