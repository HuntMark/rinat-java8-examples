package com.example.functional_interfaces;

import java.util.function.DoubleUnaryOperator;

public class StepikIntegrate {
    public static void main(String[] args) {
        System.out.println(integrate(i -> 1, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        return f.applyAsDouble(a);
    }
}
