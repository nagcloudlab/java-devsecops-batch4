package com.npci;

import com.npci.lib.TransactionsUtil;
import com.npci.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionsApplication {
    public static void main(String[] args) {

        // api-call..
        List<Transaction> transactions = new ArrayList<>();
        // create 100 transactions
        for (int i = 0; i < 100; i++) {
            String transactionId = "TXN" + (i + 1);
            String senderAccount = "ACC" + (i + 1);
            String receiverAccount = "ACC" + (i + 2);
            double amount = Math.random() * 1000;
            String timestamp = "2023-10-01T10:00:" + String.format("%02d", i % 60) + "Z";
            Transaction transaction = new Transaction(transactionId, senderAccount, receiverAccount, amount, timestamp);
            transactions.add(transaction);
        }

        List<Transaction> filteredTransactions =
                TransactionsUtil.filter(transactions, txn -> txn.getAmount() < 2000);

        System.out.println("Filtered Transactions:");
        for (Transaction txn : filteredTransactions) {
            System.out.println(txn);
        }


    }
}
