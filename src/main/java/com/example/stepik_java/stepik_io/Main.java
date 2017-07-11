package com.example.stepik_java.stepik_io;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] bytes = new int[100000];
        int counter = 0;

        int previousByte = -1;
        int currentByte;

        Scanner scanner = new Scanner(System.in);

        while ((currentByte = scanner.nextInt()) != -1) {
            if (counter > 0) {
                previousByte = bytes[counter - 1];
            }
            if (previousByte == 13 && currentByte == 10) {
                bytes[counter - 1] = currentByte;
            } else {
                bytes[counter] = currentByte;
            }
            counter++;
        }

        if (counter > 0) {
            System.out.print(bytes[0]);
        }

        counter = 1;

        while (bytes[counter] != 0) {
            System.out.print(" " + bytes[counter++]);
        }

        scanner.close();
    }
}
