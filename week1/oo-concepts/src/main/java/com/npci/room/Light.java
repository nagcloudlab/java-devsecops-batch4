package com.npci.room;

public class Light implements DoorListener {

    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }

}
