package com.npci;

import java.util.Random;
import java.util.stream.Stream;

public class How_to_Work_With_Stream {
    public static void main(String[] args) {

        /*
            step-1: build the stream -> i.e create a stream from a source
            step-2: apply the intermediate operations -> i.e filter, map, sort, etc.
            step-3: apply the terminal operation -> i.e collect, forEach, reduce, etc.
         */

        Random random = new Random();
        // building a stream from a source
        Stream.generate(() -> {
                    return random.nextInt();
                })
                .peek(n-> System.out.println("Generated number: " + n))
                //.limit(10)
                // apply intermediate operations
                .filter(number -> number >0)
                .peek(n -> System.out.println("Filtered positive number: " + n))
                // apply another intermediate operation
                //.limit(10)
                // apply terminal operation
                .forEach(System.out::println);

    }
}
