package com.npci;

import com.npci.model.Dish;
import com.npci.model.DishType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Why_We_Need_Stream_API {
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

        // find low calorie ( < 400 ) dish's names , sorted by calories
        System.out.println(
                getLowCalorieDishNames_v2(menu)
        );

    }

    // data processing pipeline
    //--------------------------

    // - filtering
    // - mapping aka transforming
    // - sorting
    //...


    //------------------------------------------
    // imperative style
    //------------------------------------------

    // problems
    // 1. too much code
    // 2. not readable
    // 3. not maintainable
    // 4. difficult to parallelize

    //--------------------------------------------
    // functional style
    //--------------------------------------------

    // using java 8 features like streams api
    // streams api is a data processing pipeline using functional programming style


    private static List<String> getLowCalorieDishNames_v1(List<Dish> input) {
        // step-1: filter low calorie dishes
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish d : input) {
            if (d.getCalories() < 400) {
                lowCalorieDishes.add(d);
            }
        }
        // step-2: sort low calorie dishes by calories
        class CalorieComparator implements java.util.Comparator<Dish> {
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        }
        lowCalorieDishes.sort(new CalorieComparator());
        // step-3: extract names of low calorie dishes
        List<String> lowCalorieDishNames = new ArrayList<>();
        for (Dish d : lowCalorieDishes) {
            lowCalorieDishNames.add(d.getName());
        }
        return lowCalorieDishNames;
    }

    private static List<String> getLowCalorieDishNames_v2(List<Dish> input) {
        return input
                .stream()
                .filter(d -> d.getCalories() < 400)
                .sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
                .map(d -> d.getName())
                .collect(Collectors.toList());
    }

}
