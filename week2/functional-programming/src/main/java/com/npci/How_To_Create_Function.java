package com.npci;

import java.util.function.*;

public class How_To_Create_Function {
    public static void main(String[] args) {

        Function<String, Integer> function = (String s) -> {
            //.....
            return s.length();
        };

        //int len = function.apply("npci");
        //System.out.println("Length of the string is: " + len);

        Predicate<String> predicate = (String s) -> {
            //.....
            return s.length() > 5;
        };

        Consumer<String> consumer = (String s) -> {
            //.....
            System.out.println("String is: " + s);
        };

        Supplier<String> supplier = () -> {
            //.....
            return "Hello, World!";
        };

        //------------------------------------------------

        BiFunction<String, String, String> biFunction = (s1, s2) -> {
            return s1 + " " + s2;
        };
        BiPredicate<String, String> biPredicate = (s1, s2) -> {
            return s1.equals(s2);
        };
        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println("First String: " + s1 + ", Second String: " + s2);
        };

        //------------------------------------------------


        UnaryOperator<String> toUpperCase = (s) -> s.toUpperCase();
        BinaryOperator<Integer> addTo = (a, b) -> a + b;

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        int r = add.apply(10, 20);
        System.out.println("Sum of 10 and 20 is: " + r);


        //------------------------------------------------

        IntBinaryOperator reduce = (a, b) -> a + b;
        int result = reduce.applyAsInt(5, 10);
        LongBinaryOperator reduce2 = (a, b) -> a + b;
        DoubleBinaryOperator reduce3 = (a, b) -> a + b;

        //------------------------------------------------

        ToIntFunction<String> toIntFunction = (s) -> s.length();
        ToLongFunction<String> toLongFunction = (s) -> s.length();
        ToDoubleFunction<String> toDoubleFunction = (s) -> s.length();

        //------------------------------------------------

        ToIntBiFunction<String, String> toIntBiFunction = (s1, s2) -> s1.length() + s2.length();
        ToLongBiFunction<String, String> toLongBiFunction = (s1, s2) -> s1.length() + s2.length();
        ToDoubleBiFunction<String, String> toDoubleBiFunction = (s1, s2) -> s1.length() + s2.length();

        //------------------------------------------------


    }
}
