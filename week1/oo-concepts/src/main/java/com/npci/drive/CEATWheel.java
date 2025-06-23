package com.npci.drive;

public class CEATWheel implements Wheel {

    public CEATWheel(){
        System.out.println("CEAT Wheel is created");
    }
    public int rotate(int speed) {
        System.out.println("CEAT Wheel is rotating");
        return 3* speed;
    }

}
