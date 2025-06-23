package com.npci;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueExampleApplication {
    public static void main(String[] args) {

//        Queue<String> queue = new java.util.LinkedList<>();
//        queue.offer("a");
//        queue.offer("b");
//        queue.offer("c");
//
//        while (!queue.isEmpty()) {
//            String element = queue.poll();
//            System.out.println("Processing element: " + element);
//        }

        //------------------------------------------------

//        Queue<String> priorityQueue = new java.util.PriorityQueue<>();
//        priorityQueue.offer("c");
//        priorityQueue.offer("a");
//        priorityQueue.offer("b");
//
//        while (!priorityQueue.isEmpty()) {
//            String element = priorityQueue.poll();
//            System.out.println("Processing element: " + element);
//        }

        //------------------------------------------------

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(20);

        // producer thread e.g produce 40 elements
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    queue.put("Element " + i);
                    System.out.println("Produced: Element " + i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Producer interrupted");
                }
            }
        });

        // consumer thread e.g consume 40 elements
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    String element = queue.take();
                    System.out.println("Consumed: " + element);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Consumer interrupted");
                }
            }
        });


        producerThread.start();
        consumerThread.start();
    }
}
