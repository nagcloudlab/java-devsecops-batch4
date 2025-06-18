package com.npci.room;

public class AC implements DoorListener {

    public void on() {
        System.out.println("AC ON");
    }

    public void off() {
        System.out.println("AC OFF");
    }

}