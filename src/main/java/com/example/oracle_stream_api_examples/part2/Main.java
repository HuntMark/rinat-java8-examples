package com.example.oracle_stream_api_examples.part2;

import com.example.oracle_stream_api_examples.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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
                new Transaction(1L, "Tashkent", Transaction.Type.COMMUNAL, new BigDecimal(300)),
                new Transaction(2L, "Tashkent", Transaction.Type.GROCERY, new BigDecimal(200)),
                new Transaction(3L, "Moscow", Transaction.Type.GROCERY, new BigDecimal(150)),
                new Transaction(4L, "Moscow", Transaction.Type.GROCERY, new BigDecimal(600)),
                new Transaction(5L, "Tashkent", Transaction.Type.COMMUNAL, new BigDecimal(200)));

        listing2();
        listing7();
        listing11(transactions);
        listing12(transactions);
        listing13(transactions);
        listing14(transactions);
        listing15(transactions);
        listing17(transactions);
        listing18(transactions);
        listing19(transactions);
        listing20(transactions);
        listing21(transactions);
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

    private static void listing12(List<Transaction> transactions) {
        int totalValue =
                transactions
                        .stream()
                        .collect(Collectors.summingInt(tr -> tr.getAmount().intValue()));
        System.out.println("Total value: " + totalValue);
    }

    private static void listing13(List<Transaction> transactions) {
        double average =
                transactions
                        .stream()
                        .collect(Collectors.averagingInt(tr -> tr.getAmount().intValue()));
        System.out.println("Average: " + average);
    }

    private static void listing14(List<Transaction> transactions) {
        Optional<Transaction> highestTransaction =
                transactions
                        .stream()
                        .collect(Collectors.maxBy(Comparator.comparing(tr -> tr.getAmount().intValue())));
        System.out.println("The highest transaction: " + highestTransaction);
    }

    private static void listing15(List<Transaction> transactions) {
        int totalValue =
                transactions
                        .stream()
                        .collect(Collectors.reducing(0, tr -> tr.getAmount().intValue(), Integer::sum));
        System.out.println("Total value: " + totalValue);
    }

    private static void listing17(List<Transaction> transactions) {
        Map<Transaction.Type, List<Transaction>> transactionsByTypes =
                transactions
                        .stream()
                        .collect(Collectors.groupingBy(Transaction::getType));
        System.out.println(transactionsByTypes);
    }

    private static void listing18(List<Transaction> transactions) {
        Map<Boolean, List<Transaction>> partitionedTransactions =
                transactions
                        .stream()
                        .collect(Collectors.partitioningBy(t -> t.getAmount().compareTo(new BigDecimal(250)) > 0));
        System.out.println(partitionedTransactions);
    }

    private static void listing19(List<Transaction> transactions) {
        Map<Transaction.Type, Integer> cityToSum =
                transactions.stream().collect(groupingBy(
                        Transaction::getType, Collectors.summingInt(t -> t.getAmount().intValue())));
        System.out.println(cityToSum);
    }

    private static void listing20(List<Transaction> transactions) {
        Map<Transaction.Type, Optional<Transaction>> cityToHighestTransaction =
                transactions.stream().collect(groupingBy(
                        Transaction::getType, Collectors.maxBy(Comparator.comparing(t -> t.getId().intValue()))));
        System.out.println(cityToHighestTransaction);
    }

    private static void listing21(List<Transaction> transactions) {
        Map<String, Map<Transaction.Type, Double>> cityByCurrencyToAverage =
                transactions
                        .stream()
                        .collect(
                                groupingBy(
                                        Transaction::getCity,
                                        groupingBy(
                                                Transaction::getType,
                                                Collectors.averagingInt(t -> t.getAmount().intValue()))));
        System.out.println(cityByCurrencyToAverage);
    }
}
