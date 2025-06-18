package com.npci.bank;


public class Application {
    public static void main(String[] args) {

        TransactionProcessor transactionProcessor = new TransactionProcessor();
        transactionProcessor.processTransaction(new CreditTransaction());
        transactionProcessor.processTransaction(new TransferTransaction());

    }
}
