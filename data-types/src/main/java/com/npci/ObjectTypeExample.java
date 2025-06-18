package com.npci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// DRY  - Don't Repeat Yourself
class Account {
    // variables
    int number; // 0  // required  , > 0
    double balance; // 0.0 // optional

    // constructor
    //public Account(){}
    // Constructor Overloading
    Account(int number) {
        this(number, 0.0); // calling another constructor
    }

    Account(int number, double balance) {
        if (number < 0) {
            throw new IllegalArgumentException("Number is negative");
        }
        this.number = number;
        this.balance = balance;
    }

    // methods
    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance -= amount;
    }

}


class AccountsManager {
    List<Account> accounts = new ArrayList<>();

    void addAccount(Account account) {
        accounts.add(account);
    }
}

public class ObjectTypeExample {
    public static void main(String[] args) throws InterruptedException {

//        Account a1 = new Account(); // 32 + 64 = 96
//        a1.number = 12345;
//        a1.balance = 100;
//
//        Account a2 = new Account();
//        a2.number = 67890;
//        a2.balance = 100;
//
//        //....
//        a1=null;
//        //..

//        Account a = new Account(123);
//        Account b = new Account(456, 1000.0);
//        a.deposit(500.0);
//        b.withdraw(500.0);
//
//        System.out.println("Account A: Number = " + a.number + ", Balance = " + a.balance);
//        System.out.println("Account B: Number = " + b.number + ", Balance = " + b.balance);


        AccountsManager am = new AccountsManager();

        for (int i = 0; i < 1000000000; i++) {
            //TimeUnit.MILLISECONDS.sleep(100);
            Account acc = new Account(i, i * 100.0); // 96 * 100000000
            am.addAccount(acc);
        }

    }
}
