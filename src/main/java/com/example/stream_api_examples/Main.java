package com.example.stream_api_examples;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void delimiter() {
        println("==============================");
    }

    private void run() {
        delimiter();
        printSumOdd();
    }

    private void printSumOdd() {
        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer sum = 0;

        for (Integer number : numbers) {
            if (number % 2 != 0) {
                sum += number;
            }
        }

        println(String.format("Plain way sum printing: %d", sum));

        sum = numbers.stream().filter(n -> n % 2 != 0).reduce((n1, n2) -> n1 + n2).orElse(0);
        println(String.format("Stream way sum printing: %d", sum));
    }
}
