package com.npci;

/*

    2 types taks
    1. CPU bound task  aka computation task
    2. IO bound task aka reading/writing with disk, network, etc.

 */

import java.util.Scanner;

/**
 *   How many threads ?
 *
 *  - computation task (CPU bound task) -
 *   # of threads <= # of CPU cores
 *  - reading/writing task (IO bound task) -
 *   # of threads > # of CPU cores
 *
 *
 *    other factors , consider h/w
 */

public class HowManyThreads {

    static void cpuBoundTask() {
        // Simulate a CPU bound task
        while (true) {
        }
    }

    static void ioBoundTask() {
        // Simulate an IO bound task
        Scanner in = new Scanner(System.in);
        System.out.println("Enter something: ");
        String input = in.nextLine();
        System.out.println("You entered: " + input);
        in.close();
    }

    public static void main(String[] args) {

        //cpuBoundTask(); // On CPU, by default java-thread is not blocked
        //ioBoundTask(); // On IO, by default java-thread blocked

    }
}
