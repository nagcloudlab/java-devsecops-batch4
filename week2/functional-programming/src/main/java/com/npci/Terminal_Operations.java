package com.npci;

import com.npci.model.Dish;
import com.npci.model.DishType;

import java.util.Arrays;
import java.util.List;

public class Terminal_Operations {


    public static void main(String[] args) {

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, DishType.MEAT),
                new Dish("beef", false, 700, DishType.MEAT),
                new Dish("chicken", false, 400, DishType.MEAT),
                new Dish("french fries", true, 530, DishType.OTHER),
                new Dish("rice", true, 350, DishType.OTHER),
                new Dish("season fruit", true, 120, DishType.OTHER),
                new Dish("pizza", true, 550, DishType.OTHER),
                new Dish("prawns", false, 400, DishType.FISH),
                new Dish("salmon", false, 450, DishType.FISH));

        // Terminal operations => how we get the result

        //1. .collect()  with with Collectors

        // a. toList()
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.toList())
        );

        // b. toSet()
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.toSet())
        );

        // c. toMap()
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.toMap(Dish::getName, Dish::getCalories))
        );

        // d. joining() -> joining the names of vegetarian dishes
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .map(Dish::getName)
                        .collect(java.util.stream.Collectors.joining(", ", "{", "}"))
        );

        // e. counting() -> counting the number of vegetarian dishes
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.counting())
        );

        // f. summingInt() -> summing the calories of vegetarian dishes
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.summingInt(Dish::getCalories))
        );

        // g. summarizingInt() -> summarizing the calories of vegetarian dishes
        System.out.println(
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(java.util.stream.Collectors.summarizingInt(Dish::getCalories))
        );

        // h. partitioningBy() -> partitioning the dishes into vegetarian and non-vegetarian
        System.out.println(
                menu.stream()
                        .collect(java.util.stream.Collectors.partitioningBy(Dish::isVegetarian))
        );

        // i. groupingBy() -> grouping the dishes by type
        System.out.println(
                menu.stream()
                        .collect(java.util.stream.Collectors.groupingBy(Dish::getType))
        );

        // j. groupingBy() with multiple fields
        System.out.println(
                menu.stream()
                        .collect(java.util.stream.Collectors.groupingBy(
                                Dish::getType,
                                java.util.stream.Collectors.partitioningBy(Dish::isVegetarian)
                        ))
        );

        // 2. reduce() -> reducing the stream to a single value

        System.out.println(
                menu.stream()
                        .map(Dish::getCalories)
                        .reduce(0, Integer::sum) // summing the calories of vegetarian dishes
        );

        // 3. forEach() -> iterating over the stream
        menu.stream()
                .filter(Dish::isVegetarian)
                .forEach(dish -> System.out.println(dish.getName() + " is a vegetarian dish with " + dish.getCalories() + " calories."));


        // 4. findFirst() -> finding the first element in the stream
        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(dish -> System.out.println("First vegetarian dish: " + dish.getName()));


        // 5. anyMatch(), allMatch(), noneMatch() -> checking conditions on the stream

        System.out.println(
                menu.stream()
                        .anyMatch(Dish::isVegetarian)
        );

        System.out.println(
                menu.stream()
                        .allMatch(Dish::isVegetarian)
        );

        System.out.println(
                menu.stream()
                        .noneMatch(Dish::isVegetarian)
        );

    }

}

