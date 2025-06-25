package com.npci;

import java.util.ArrayList;
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

public class Exercise_1 {
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

        // remove non-veg items from the foodMenu

    }
}
