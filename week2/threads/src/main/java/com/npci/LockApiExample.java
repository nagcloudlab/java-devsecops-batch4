package com.npci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockApiExample {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Runnable task1 = () -> {
            lock.tryLock();
            try {
                System.out.println("Task 1 is running");
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                System.out.println("Task 1 has finished");
            }
        };

        Runnable task2 = () -> {
            lock.lock();
            try {
                System.out.println("Task 2 is running");
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
                System.out.println("Task 2 has finished");
            }
        };

        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(10);
        executorService.submit(task1);
        executorService.submit(task2);

    }
}
