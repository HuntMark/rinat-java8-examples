package com.example.oracle_stream_api_examples;

import java.math.BigDecimal;

public class Transaction {
    public enum Type {
        COMMUNAL, GROCERY
    }

    private Long id;
    private String city;
    private Type type;
    private BigDecimal amount = new BigDecimal(0);

    public Transaction(Long id, Type type, BigDecimal amount) {
        this(id, "Moscow", type, amount);
    }

    public Transaction(Long id, String city, Type type, BigDecimal amount) {
        this.id = id;
        this.city = city;
        this.type = type;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
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
                ", city='" + city + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
