package com.npci.drive;

// principal : Open for extension, closed for modification
// how to achieve this? interface and dependency injection
// then object become polymorphic
public class Car {

    Wheel wheel; // required dependency

    public Car(Wheel wheel) {
        this.wheel = wheel; // inject dependency
        System.out.println("Car is created");
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel; // allow changing the wheel
        System.out.println("Car wheel is set");
    }

    public void move() {
        int rpm = this.wheel.rotate(100);
        System.out.println("Car is moving with wheel rpm: " + rpm);
    }

}
