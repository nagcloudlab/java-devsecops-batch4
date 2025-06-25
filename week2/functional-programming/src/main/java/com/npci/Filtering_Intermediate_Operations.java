package com.npci;

import com.npci.model.Dish;
import com.npci.model.DishType;
import com.npci.model.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filtering_Intermediate_Operations {
    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(2, 1, 3, 4, 5, 5, 6, 7, 8, 9);


        // filtering
        // ----------------------------
        // .filter() -> content based filtering
        // .skip() , limit() -> position based filtering
        // .distinct() -> unique filtering
        // .takeWhile() -> take elements while condition is true
        // .dropWhile() -> drop elements while condition is true

        // .filter()
        numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);// filter even numbers

        System.out.println();

        numbers.stream()
                .skip(5)
                .limit(5)
                .forEach(System.out::println); // limit to first 5 elements

        System.out.println();

        numbers.stream()
                .distinct() // .equals() method is used to filter unique elements
                .forEach(System.out::println); // filter unique elements


        //------------------------------------------------------------------

        List<Transaction> transactions = new ArrayList<>();
        // create 1M transactions
        // from file | database | API | Kafka | etc.
        for (int i = 0; i < 100000; i++) {
            Transaction transaction = new Transaction(
                    "TXN" + i,
                    "source_" + (i % 100), // 100 unique sources
                    "destination_" + (i % 100), // 100 unique destinations
                    100 + i,
                    "2023-10-01T10:00:" + (i % 60) // varying seconds
            );
            transactions.add(transaction); // sorted by amount
        }

        //need all transactions where amount below 150
        transactions
                .stream()
                .peek(t -> System.out.println("Filtering transaction: " + t)) // peek to see each transaction
                .takeWhile(t -> t.getAmount() < 150)
                .forEach(t -> System.out.println("Output transaction: " + t)); // filter transactions with amount below 150


    }
}
