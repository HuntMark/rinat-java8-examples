package com.example.introducing_java8.lambdas;

import com.example.introducing_java8.lambdas.Customer;
import com.example.introducing_java8.lambdas.Invoice;
import com.example.introducing_java8.lambdas.InvoicePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {
    public static List<Invoice> findInvoices(List<Invoice> invoices, InvoicePredicate predicate) {
        List<Invoice> result = new ArrayList<>();
        for (Invoice invoice : invoices) {
            if (predicate.test(invoice)) {
                result.add(invoice);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Invoice> invoices = Arrays.asList(
                new Invoice(10, Customer.ORACLE),
                new Invoice(15, Customer.GOOGLE),
                new Invoice(20, Customer.ORACLE),
                new Invoice(25, Customer.GOOGLE),
                new Invoice(30, Customer.ORACLE));

        // Prior Java 8
        List<Invoice> filtered1 = findInvoices(invoices, new InvoicePredicate() {
            @Override
            public boolean test(Invoice invoice) {
                return invoice.getAmount() > 10 && invoice.getCustomer() == Customer.ORACLE;
            }
        });

        // With Java 8
        List<Invoice> filtered2 = findInvoices(invoices,
                invoice -> invoice.getAmount() > 10 && invoice.getCustomer() == Customer.ORACLE);

        System.out.println(Arrays.toString(filtered1.toArray()));
        System.out.println(Arrays.toString(filtered2.toArray()));
    }
}
