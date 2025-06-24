package com.npci;

import com.npci.lib.ApplesUtil;
import com.npci.model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InventoryApplication {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple("red", 150.0));
        inventory.add(new Apple("green", 120.0));
        inventory.add(new Apple("green", 130.0));
        inventory.add(new Apple("red", 160.0));


        //-----------------------------
        // before java 8,  more code to write
        //-----------------------------

        class RedApplePredicate implements Predicate<Apple> {
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        }
        class GreenApplePredicate implements Predicate<Apple> {
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        }
        class HeavyApplePredicate implements Predicate<Apple> {
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        }

        // Req-1: filter 'green' apples from inventory
        System.out.println(
                ApplesUtil.filterApples(inventory, new GreenApplePredicate())
        );

        // Req-2: filter 'red' apples from inventory
        System.out.println(
                ApplesUtil.filterApples(inventory, new RedApplePredicate())
        );

        // Req-3: filter 'heavy weight' apples from inventory
        System.out.println(
                ApplesUtil.filterApples(inventory, new HeavyApplePredicate())
        );

        System.out.println();
        System.out.println();


        //----------------------------------------------------------------------
        // From java 8 onwards, we can use lambda expressions aka function,
        // to make the code more 'concise'
        //----------------------------------------------------------------------

        // Req-1: filter 'green' apples from inventory

        // (input) ->{}  --> Lambda expression
        System.out.println(
                ApplesUtil.filterApples(inventory, (t) -> "green".equals(t.getColor()))
        );
        // Req-2: filter 'red' apples from inventory
        System.out.println(
                ApplesUtil.filterApples(inventory, (t) -> "red".equals(t.getColor()))
        );
        // Req-3: filter 'heavy weight' apples from inventory
        System.out.println(
                ApplesUtil.filterApples(inventory, (t) -> t.getWeight() > 150)
        );

    }

}

