package com.example.stepik_java.stepik_io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] bytes = new int[100000];
        int counter = 0;

        byte[] arr = {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        ByteArrayInputStream inputStream = new ByteArrayInputStream(arr);
        System.setIn(inputStream);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int currentByte = scanner.nextInt();
            if (currentByte == 10) {
                while (counter > 0 && bytes[counter - 1] == 13) {
                    bytes[counter - 1] = currentByte;
                    if (bytes[counter] != 0) {
                        bytes[counter] = 0;
                    }
                    counter--;
                }
            }
            bytes[counter] = currentByte;
            counter++;
        }

        counter = 0;

        while (bytes[counter] != 0) {
            System.out.print(bytes[counter] + " ");
            System.out.write(bytes[counter]);
            counter++;
        }

        System.out.flush();

        scanner.close();
    }
}
