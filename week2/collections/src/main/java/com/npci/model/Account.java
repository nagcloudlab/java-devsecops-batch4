package com.npci.model;


import java.util.Objects;

/*
Author : nag
 */
public class Account extends Object implements Comparable<Account> {

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

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }


}
