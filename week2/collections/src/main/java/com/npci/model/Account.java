package com.npci.model;


/*
Author : nag
 */
public class Account implements Comparable<Account> {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public int compareTo(Account o) {
        return this.accountNumber.compareTo(o.accountNumber);
    }

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }


}
