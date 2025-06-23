package com.npci.accessor;

public class Application {

    public static void main(String[] args) {

        //---------------------------------------
        // senior developer
        //----------------------------------------
        Account account = new Account(12345);
        System.out.println(account.getNumber());
        System.out.println(account.getBalance());

        //---------------------------------------
        // junior developer
        //----------------------------------------
        // account.number = -12345;

        //---------------------------------------
        // senior developer
        //----------------------------------------
        System.out.println(account.getNumber());
        System.out.println(account.getBalance());


    }

}
