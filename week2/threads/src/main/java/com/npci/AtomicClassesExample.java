package com.npci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicClassesExample {
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                atomicInteger.incrementAndGet();
            }
        };

        for (Integer i = 0; i < 100; i++) {
            executorService.submit(task);
        }

        Thread.sleep(5000); // Wait for tasks to complete

        System.out.println("Final value of AtomicInteger: " + atomicInteger.get());


    }
}
