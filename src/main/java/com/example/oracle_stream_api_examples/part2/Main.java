package com.example.oracle_stream_api_examples.part2;

import com.example.oracle_stream_api_examples.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Rinat Zalyaletdinov.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, Transaction.Type.COMMUNAL, new BigDecimal(300)),
                new Transaction(2L, Transaction.Type.GROCERY, new BigDecimal(200)),
                new Transaction(3L, Transaction.Type.GROCERY, new BigDecimal(150)),
                new Transaction(4L, Transaction.Type.GROCERY, new BigDecimal(600)),
                new Transaction(5L, Transaction.Type.COMMUNAL, new BigDecimal(200)));

        listing2();
        listing7();
        listing11(transactions);
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
        /*
        In a nutshell, flatMap lets you replace each value of a stream with another stream,
        and then it concatenates all the generated streams into one single stream.
         */
        Files.lines(Paths.get("stuff.txt"))
                .map(line -> line.split("\\s+"))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    private static void listing11(List<Transaction> transactions) {
        long howManyTransactions =
                transactions
                        .stream()
                        .collect(Collectors.counting());
        System.out.println("How many transactions? " + howManyTransactions);
    }
}
