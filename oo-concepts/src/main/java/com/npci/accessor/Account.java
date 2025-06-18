package com.npci.accessor;

// Lombok
public class Account {

    private int number;
    private double balance;

//    public Account(){}
    public Account(int number){
        if(number < 0){
            throw new IllegalArgumentException("Account number cannot be negative");
        }
        this.number = number;
    }

    // public accessor methods ( set & get )
    public int getNumber() {
        return number;
    }
    public void setBalance(double balance) {
        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

}
