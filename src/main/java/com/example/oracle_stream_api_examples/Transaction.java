package com.example.oracle_stream_api_examples;

import java.math.BigDecimal;

public class Transaction {
    public enum Type {
        COMMUNAL, GROCERY
    }

    private Long id;
    private Type type;
    private BigDecimal amount = new BigDecimal(0);

    public Transaction(Long id, Type type, BigDecimal amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
