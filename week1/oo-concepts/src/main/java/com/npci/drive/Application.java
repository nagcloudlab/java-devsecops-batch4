package com.npci.drive;

public class Application {

    public static void main(String[] args) {


        Wheel mrfWheel = new MRFWheel();
        Car car = new Car(mrfWheel);
        System.out.println();

        car.move();
        System.out.println();
        car.move();

        System.out.println();
        Wheel ceatWheel = new CEATWheel();
        car.setWheel(ceatWheel);

        System.out.println();
        car.move();


    }

}
