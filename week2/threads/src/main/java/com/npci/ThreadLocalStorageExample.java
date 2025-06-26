package com.npci;


//----------------------------------------------
// Layer-3
//----------------------------------------------

class LayerThreeComponent {
    public void m3() {
        // Access the ThreadLocal variable
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String value = threadLocal.get();
        if (value != null) {
            System.out.println("ThreadLocal value in Layer 3: " + value);
        } else {
            System.out.println("ThreadLocal value is not set in Layer 3.");
        }
    }
}


//----------------------------------------------
// Layer-2
//----------------------------------------------

class LayerTWoComponent {
    public void m2() {
        new LayerThreeComponent().m3();
    }
}


//----------------------------------------------
// Layer-1
//----------------------------------------------

class LayerOneComponent {
    public void m1() {
        new LayerTWoComponent().m2();
    }
}


public class ThreadLocalStorageExample {
    public static void main(String[] args) {


        Runnable task = () -> {
            ThreadLocal<String> threadLocal = new ThreadLocal<>();
            threadLocal.set("NPCi");
            // Create an instance of LayerOneComponent
            LayerOneComponent layerOne = new LayerOneComponent();
            // Call the method m1 which will trigger the chain of method calls
            layerOne.m1();


        };

        Thread thread = new Thread(task);
        thread.start();


    }
}
