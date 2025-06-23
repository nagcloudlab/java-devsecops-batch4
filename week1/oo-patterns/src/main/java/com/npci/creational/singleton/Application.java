package com.npci.creational.singleton;

/**
 * author: Nikhil
 */

class AppConfig {
    private AppConfig() {
        System.out.println("AppConfig created");
    }
    //public static AppConfig appConfig = new AppConfig(); // Eager Initialization
    private static AppConfig instance; // = null; // Lazy Initialization
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}

// use case of Singleton Pattern
// 1. Database Connection Pool
// 2. Logger
// 3. Configuration Manager
// 4. Thread Pool
// 5. Cache Manager
// 6. Application Context in Spring Framework
//....

public class Application {
    public static void main(String[] args) {

        //--------------------------
        // Module-1
        //--------------------------
        //AppConfig appConfig1 = new AppConfig();
        //AppConfig appConfig1 = AppConfig.appConfig;
        AppConfig appConfig1 = AppConfig.getInstance();

        //--------------------------
        // Module-2
        //--------------------------
        //AppConfig appConfig2 = new AppConfig();
        //AppConfig appConfig2 = AppConfig.appConfig;
        AppConfig appConfig2 = AppConfig.getInstance();

        System.out.println(appConfig1 == appConfig2); // true


    }
}
