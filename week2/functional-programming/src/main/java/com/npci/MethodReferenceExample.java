package com.npci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FoodUtil {
    public static boolean isVeg(String foodItem) {
        // Check if the food item is vegetarian
        String[] vegItems = {"Paneer Tikka", "Veg Pulao", "Mushroom Soup", "Vegetable Salad"};
        for (String item : vegItems) {
            if (item.equalsIgnoreCase(foodItem)) {
                return true;
            }
        }
        return false;
    }
}

public class MethodReferenceExample {
    public static void main(String[] args) {

        List<String> foodMenu = new ArrayList<>();
        // add veg & non-veg items to the foodMenu
        foodMenu.add("Paneer Tikka");
        foodMenu.add("Chicken Biryani");
        foodMenu.add("Veg Pulao");
        foodMenu.add("Fish Curry");
        foodMenu.add("Mushroom Soup");
        foodMenu.add("Egg Curry");
        foodMenu.add("Vegetable Salad");

        // remove veg items from the foodMenu

        //------------------------------------------------
        // style: imperative
        //------------------------------------------------
//        Iterator<String> iterator = foodMenu.iterator();
//        while (iterator.hasNext()) {
//            String foodItem = iterator.next();
//            if (FoodUtil.isVeg(foodItem)) {
//                iterator.remove(); // Remove non-veg items
//            }
//        }
//        System.out.println("Vegetarian Food Menu: " + foodMenu);

        //------------------------------------------------
        // style: functional
        //------------------------------------------------

        //foodMenu.removeIf(foodItem -> FoodUtil.isVeg(foodItem));

        foodMenu.removeIf(FoodUtil::isVeg); // method reference, using java method as a LE | function

        System.out.println("Non-Vegetarian Food Menu: " + foodMenu);

    }
}
