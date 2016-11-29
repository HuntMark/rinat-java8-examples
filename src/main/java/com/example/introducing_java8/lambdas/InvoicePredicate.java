package com.example.introducing_java8.lambdas;

/**
 * Behaviour Parameterization Pattern.
 */
public interface InvoicePredicate {
    boolean test(Invoice invoice);
}
