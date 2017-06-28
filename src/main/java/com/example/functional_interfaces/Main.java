package com.example.functional_interfaces;

import java.util.function.DoubleUnaryOperator;

/**
 * @author Rinat_Zalyaletdinov
 */
public class Main {
    public static void main(String[] args) {
        DoubleUnaryOperator power = operand -> Math.pow(operand, 2);
        System.out.println(power.applyAsDouble(10));

        DoubleUnaryOperator subtracter = val -> {
            System.out.println("val in subtracter: " + val);
            val = val - 10.9;
            System.out.println("subtracter: " + val);
            return val;
        };

        DoubleUnaryOperator adder = val -> {
            System.out.println("val in adder: " + val);
            val = val + 10.5;
            System.out.println("adder: " + val);
            return val;
        };

        System.out.println("=====");
        System.out.println("Test compose()");
        adder.compose(subtracter).applyAsDouble(33);

        System.out.println("=====");
        System.out.println("Test andThen()");
        adder.andThen(subtracter).applyAsDouble(33);
    }
}
