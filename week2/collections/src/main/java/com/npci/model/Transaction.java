package com.npci.model;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private TransactionType transactionType; // e.g., "credit", "debit"
    private String timestamp;

    public Transaction(String transactionId, String accountNumber, double amount, TransactionType transactionType, String timestamp) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
