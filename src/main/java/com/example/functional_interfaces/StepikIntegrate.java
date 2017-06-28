package com.example.functional_interfaces;

import java.util.function.DoubleUnaryOperator;

public class StepikIntegrate {
    public static void main(String[] args) {
        System.out.println(integrate(i -> 1, 0, 10));
        System.out.println(integrate(x -> x + 2, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        double result, h;

        result = 0;

        int n = 1_000_000;

        h = (b - a) / n;

        for (i = 0; i < n; i++) {
            result += f.applyAsDouble(a + h * (i + 0.5)); //Вычисляем в средней точке и добавляем в сумму
        }

        result *= h;

        return result;
    }
}
