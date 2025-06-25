package com.npci;

import com.npci.lib.TransactionLib;
import com.npci.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Why_We_Need_Lambda_Expressions {

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();
        // create 1M transactions
        // from file | database | API | Kafka | etc.
        for (int i = 0; i < 1000000; i++) {
            Transaction transaction = new Transaction(
                    "TXN" + i,
                    "source_" + (i % 100), // 100 unique sources
                    "destination_" + (i % 100), // 100 unique destinations
                    100 + i,
                    "2023-10-01T10:00:" + (i % 60) // varying seconds
            );
            transactions.add(transaction);
        }

        // data processing e.g filter transactions

        //---------------------------------------------------------------------
        // before java-8
        //---------------------------------------------------------------------
        // Req-1: filter transactions with amount < 1000
        class TransactionsLessThan1000 implements Predicate<Transaction> {
            public boolean test(Transaction transaction) {
                return transaction.getAmount() < 1000;
            }
        }
        List<Transaction> output = TransactionLib.filter(transactions, new TransactionsLessThan1000());
        //displayOutput(output);

        //---------------------------------------------------------------------
        // from java-8, we Lambda expressions
        // advantage: less code, more readable
        //---------------------------------------------------------------------
        output = TransactionLib.filter(transactions, transaction -> transaction.getAmount() < 1000);
        //displayOutput(output);

        // Req-2: filter transactions with source containing "source_1"
        output = TransactionLib.filter(transactions, transaction -> transaction.getSenderAccount().equals("source_1"));
        displayOutput(output);

    }

    private static void displayOutput(List<Transaction> transactions) {
        System.out.println("Total Transactions: " + transactions.size());
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

}
