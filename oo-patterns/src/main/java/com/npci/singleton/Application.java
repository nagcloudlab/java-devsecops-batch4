package com.npci.singleton;

/**
 * author: Nikhil
 */

class AppConfig {
    //....
    public AppConfig() {
        System.out.println("AppConfig created");
    }
}

public class Application {
    public static void main(String[] args) {

        //--------------------------
        // Module-1
        //--------------------------
        AppConfig appConfig1 = new AppConfig();

        //--------------------------
        // Module-2
        //--------------------------
        AppConfig appConfig2 = new AppConfig();


    }
}
