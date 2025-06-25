package com.npci;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Map_Intermediate_Operation {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        // .map() is an intermediate operation that transforms each element of the stream
        // n input -> n output
        numbers.stream()
                .map(number -> number * number)
                .forEach(System.out::println);

        // .flatMap() is an intermediate operation that transforms each element of the stream
        // n -input -> o or more output

        System.out.println();
        numbers
                .stream()
                .flatMap(n -> Stream.of(n, n * n, n * n * n))
                .forEach(System.out::println);


        // Example of flatMap with
        String[] foodMenu = {
                "idly,dosa,poori",
                "meals",
                "biryani,parotta",
        };
        System.out.println();
        Stream.of(foodMenu)
                .flatMap(line-> Arrays.stream(line.split(",")))
                .map(String::trim)
                .filter(food -> food.startsWith("p"))
                .forEach(System.out::println);
    }
}
