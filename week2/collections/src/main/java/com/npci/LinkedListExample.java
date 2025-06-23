package com.npci;

import com.npci.util.LinkedList;

import java.util.Iterator;

public class LinkedListExample {
    public static void main(String[] args) {

        LinkedList<String> stringColln = new LinkedList<>();
        stringColln.add("acc1"); // 0
        stringColln.add("acc3"); // 2
        stringColln.add(1, "acc2"); // 1
        int size = stringColln.size();
        //System.out.println("Size of linked list: " + size);
        // loop through the linked list and print each element
        // way-1: traditional for loop
        for (int i = 0; i < size; i++) {
            System.out.println("Element at index " + i + ": " + stringColln.get(i));
        }

        LinkedList<Integer> numberColln = new LinkedList<>();
        numberColln.add(10); // 0 ( Autoboxing int to Integer )
        numberColln.add(20); // 1
        numberColln.add(30); // 2
        //numberColln.add("hello");

        Iterator<Integer> iterator = numberColln.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            System.out.println("Number: " + number);
        }

        // way-2: for-each loop ( java 5+ feature )
        for (Integer n : numberColln) {
            System.out.println("Number: " + n);
        }


    }
}
