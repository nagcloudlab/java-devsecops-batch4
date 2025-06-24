package com.npci.lib;

import com.npci.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public
class ApplesUtil {

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> obj) {
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple apple : inventory) {
            if (obj.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

//    public static List<Apple> filterApplesByWight(List<Apple> inventory, double weight) {
//        List<Apple> filteredApples = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > weight) {
//                filteredApples.add(apple);
//            }
//        }
//        return filteredApples;
//    }
//
//    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
//        List<Apple> filteredApples = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if (color.equals(apple.getColor())) {
//                filteredApples.add(apple);
//            }
//        }
//        return filteredApples;
//    }
//
//    public static List<Apple> filterRedApples(List<Apple> inventory) {
//        List<Apple> redApples = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if ("red".equals(apple.getColor())) {
//                redApples.add(apple);
//            }
//        }
//        return redApples;
//    }
//
//    public static List<Apple> filterGreenApples(List<Apple> inventory) {
//        List<Apple> greenApples = new ArrayList<>();
//        for (Apple apple : inventory) {
//            if ("green".equals(apple.getColor())) {
//                greenApples.add(apple);
//            }
//        }
//        return greenApples;
//    }
}

