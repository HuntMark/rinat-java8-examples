package com.example.introducing_java8.lambdas;

public class Invoice {
    private Integer amount;
    private Customer customer;

    public Invoice(Integer amount, Customer customer) {
        this.amount = amount;
        this.customer = customer;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
