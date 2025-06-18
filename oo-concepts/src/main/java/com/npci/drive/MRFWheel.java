package com.npci.drive;

public class MRFWheel implements Wheel {

    public MRFWheel() {
        System.out.println("MRF Wheel is created");
    }

    public int rotate(int speed) {
        System.out.println("MRF Wheel is rotating");
        return 2 * speed;
    }

}
