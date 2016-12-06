package com.example.oracle_stream_api_examples;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    }

    public static List<Long> findTransactionIdsByType(List<Transaction> transactions, Transaction.Type type) {
        return transactions
                .stream()
                .filter((t) -> t.getType() == type)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());
    }
}
