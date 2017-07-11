package com.example.stepik_java.stepik_io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckSumOfStream {
    public static void main(String[] args) throws IOException {
        byte[] bytes = {0x33, 0x45, 0x01};
        System.out.println(checkSumOfStream(new ByteArrayInputStream(bytes)));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;

        int nextByte;
        while ((nextByte = inputStream.read()) != -1) {
            sum = Integer.rotateLeft(sum, 1) ^ nextByte;
        }

        return sum;
    }
}
