package com.npci;

import com.npci.model.Car;
import com.npci.model.Owner;

import java.util.*;

public class MapExampleApplication2 {
    public static void main(String[] args) {

        Owner owner1 = new Owner("riya", "1234567890");
        Owner owner2 = new Owner("diya", "0987654321");

        Car car1 = new Car("red", "honda", 2025);
        Car car2 = new Car("blue", "toyota", 2024);

        //Map<Owner, Car> cars = new TreeMap<>();
        Map<Owner, Car> cars = new HashMap<>();
        cars.put(owner1, car1);
        cars.put(owner2, car2);

        //--------------------------------------------------------------

//        Set<Owner> owners = cars.keySet();
//        for (Owner owner : owners) {
//            Car car = cars.get(owner);
//            System.out.println("Owner: " + owner.getName() + ", Contact: " + owner.getContactNumber() + ", Car: " + car);
//        }

        //--------------------------------------------------------------

        Scanner input = new Scanner(System.in);
        System.out.println("Enter owner name to search for car:");
        String ownerName = input.nextLine();
        System.out.println("Enter owner contact number to search for car:");
        String ownerContact = input.nextLine();
        Owner key = new Owner(ownerName, ownerContact); // Create a temporary Owner object with the name to search
        Car car = cars.get(key);
        if (car != null) {
            System.out.println("Car found: " + car);
        } else {
            System.out.println("No car found for owner: " + ownerName);
        }


    }
}
