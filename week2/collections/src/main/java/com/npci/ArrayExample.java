package com.npci;


public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5}; // 5 * 4 bytes = 20 bytes
        int[] moreNumbers = new int[5]; // 5 * 4 bytes = 20 bytes
        moreNumbers[0] = 10;
        moreNumbers[1] = 20;
        moreNumbers[2] = 30;
        moreNumbers[3] = 40;
        moreNumbers[4] = 50;
        //----------------------------------
        class Employee {
            String name;
            int age;

            Employee(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Alice", 30);
        employees[1] = new Employee("Bob", 25);
        employees[2] = new Employee("Charlie", 35);
        //----------------------------------
        // how to access elements
        //-----------------------------------
        System.out.println("First number: " + numbers[0]); // Accessing first element
        // How to loop through an array
        System.out.println("Numbers in the array:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        // Enhanced for loop ( java 1.5+)
        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
