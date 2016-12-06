package com.example.oracle_stream_api_examples;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1L, Transaction.Type.COMMUNAL, new BigDecimal(300)),
                new Transaction(2L, Transaction.Type.GROCERY, new BigDecimal(100)),
                new Transaction(3L, Transaction.Type.GROCERY, new BigDecimal(150)),
                new Transaction(4L, Transaction.Type.GROCERY, new BigDecimal(600)),
                new Transaction(5L, Transaction.Type.COMMUNAL, new BigDecimal(200)));

        System.out.println(Arrays.toString(findTransactionIdsByType(transactions, Transaction.Type.GROCERY).toArray()));
    }

    public static List<Long> findTransactionIdsByType(List<Transaction> transactions, Transaction.Type type) {
        List<Transaction> filtered = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getType() == type) {
                filtered.add(transaction);
            }
        }

        Collections.sort(filtered, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getAmount().compareTo(t2.getAmount());
            }
        });

        List<Long> ids = new ArrayList<>();
        for (Transaction transaction : filtered) {
            ids.add(transaction.getId());
        }

        return ids;
    }
}
