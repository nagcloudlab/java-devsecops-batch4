package com.npci.room;

public class TV implements DoorListener {

    @Override
    public void on() {
        System.out.println("TV is now ON");
    }

    @Override
    public void off() {
        System.out.println("TV is now OFF");
    }

}
