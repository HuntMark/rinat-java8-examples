package com.example.functional_interfaces;

import java.math.BigInteger;

public class StepikMain {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.measureTime(new RunnableImpl());
    }
}

class MyTimer {
    public void measureTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        System.out.println("Execution time: " + (System.currentTimeMillis() - startTime));
    }
}

class RunnableImpl implements Runnable {
    @Override
    public void run() {
        new BigInteger("12345").pow(10000);
    }
}
