package com.npci.room;

public class Door {

    Light light = new Light();
    AC ac = new AC();

    public void open() {
        System.out.println("Door Opened");
        light.on();
        ac.on();
    }

    public void close() {
        System.out.println("Door Closed");
        light.off();
        ac.off();
    }
}
