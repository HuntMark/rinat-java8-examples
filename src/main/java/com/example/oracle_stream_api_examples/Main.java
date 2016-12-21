package com.example.oracle_stream_api_examples;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, Transaction.Type.COMMUNAL, new BigDecimal(300)),
                new Transaction(2L, Transaction.Type.GROCERY, new BigDecimal(200)),
                new Transaction(3L, Transaction.Type.GROCERY, new BigDecimal(150)),
                new Transaction(4L, Transaction.Type.GROCERY, new BigDecimal(600)),
                new Transaction(5L, Transaction.Type.COMMUNAL, new BigDecimal(200)));

        System.out.println(Arrays.toString(findTransactionIdsByType(transactions, Transaction.Type.GROCERY).toArray()));
        listing7(transactions);
        listing8(transactions);
        listing9(transactions);
        listing10();
    }

    public static List<Long> findTransactionIdsByType(List<Transaction> transactions, Transaction.Type type) {
        return transactions
                .stream()
                .filter((t) -> t.getType() == type)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());
    }

    private static void listing7(List<Transaction> transactions) {
        boolean expensive =
                transactions
                        .stream()
                        .allMatch(tr -> tr.getAmount().compareTo(new BigDecimal(100)) > 0);

        System.out.println("Are they all expensive? " + expensive);
    }

    private static void listing8(List<Transaction> transactions) {
        Optional<Transaction> any =
                transactions
                        .stream()
                        .filter(tr -> tr.getType() == Transaction.Type.GROCERY)
                        .findAny();

        System.out.println("Any transaction of grocery: " + any.orElse(null));
    }

    private static void listing9(List<Transaction> transactions) {
        transactions
                .stream()
                .filter(tr -> tr.getType() == Transaction.Type.GROCERY)
                .findAny()
                .ifPresent(System.out::println);
    }

    private static void listing10() {
        List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLengths =
                words
                        .stream()
                        .map(String::length)
                        .collect(Collectors.toList());
        System.out.println(wordLengths);
    }
}
