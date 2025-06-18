package com.npci.room;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        Light light = new Light();
        AC ac = new AC();

        door.addListener(light);
        door.addListener(ac);

        door.open();
        Thread.sleep(2000);
        door.close();

        door.removeListener(ac);
        door.addListener(new TV());

        door.open();
        Thread.sleep(2000);
        door.close();

    }
}
