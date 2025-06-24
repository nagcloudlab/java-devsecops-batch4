package com.npci;

import com.npci.model.Dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingExample {
    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

//        Collections.sort(menu,(d1,d2)->d1.getName().compareTo(d2.getName()));
        Collections.sort(menu, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));

        // display
        displyMenu(menu);

    }

    private static void displyMenu(List<Dish> menu) {
        System.out.println("Menu:");
        for (Dish dish : menu) {
            System.out.println(dish.getName() + " - " + dish.getCalories() + " calories, " + dish.getType());
        }
    }

}
