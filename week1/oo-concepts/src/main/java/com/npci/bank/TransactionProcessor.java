package com.npci.bank;

/*
 transaction types
    1. Credit
    2. Debit
    3. Transfer
    4. fee
 */

public class TransactionProcessor {

    public void processTransaction(BankTransaction transaction) {
        // Process the transaction
        transaction.process();

        // Log the transaction details
        System.out.println("Transaction Details: " + transaction.getDetails());

        // Additional processing logic can be added here
    }


}
