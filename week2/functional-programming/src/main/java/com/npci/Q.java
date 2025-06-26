package com.npci;

import java.util.List;
import java.util.stream.Stream;

public class Q {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> s = list
                .stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i);

        s.forEach(System.out::println);
        System.out.println();

        list.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .forEach(System.out::println);

    }
}
