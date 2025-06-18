package com.npci.room;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        Door door = new Door();

        door.open();
        Thread.sleep(2000);
        door.close();

    }
}
