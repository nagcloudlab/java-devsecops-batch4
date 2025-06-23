package com.npci;

import com.npci.model.Account;
import com.npci.model.Transaction;
import com.npci.model.TransactionType;

import java.util.*;

public class MapExampleApplication {
    public static void main(String[] args) {

        Account account1 = new Account("acc_1", "name_1", 100.00);
        Account account2 = new Account("acc_2", "name_2", 200.00);

        List<Transaction> account1_transactions = new ArrayList<>();
        account1_transactions.add(new Transaction("txn_1", "acc_1", 50.00, TransactionType.CREDIT, "2023-10-01T10:00:00Z"));
        account1_transactions.add(new Transaction("txn_2", "acc_1", 20.00, TransactionType.DEBIT, "2023-10-01T11:00:00Z"));
        List<Transaction> account2_transactions = new ArrayList<>();
        account2_transactions.add(new Transaction("txn_3", "acc_2", 100.00, TransactionType.CREDIT, "2023-10-01T12:00:00Z"));
        account2_transactions.add(new Transaction("txn_4", "acc_2", 50.00, TransactionType.DEBIT, "2023-10-01T13:00:00Z"));


//        Map<Account, List<Transaction>> account_transactions = new TreeMap<>();
//        Map<Account, List<Transaction>> account_transactions = new HashMap<>();
        Map<Account, List<Transaction>> account_transactions = new LinkedHashMap<>();
        account_transactions.put(account1, account1_transactions);
        account_transactions.put(account2, account2_transactions);

        //----------------------------------------------------------------

        List<Transaction> transactions = account_transactions.get(account1);
        if (transactions != null) {
            for (Transaction transaction : transactions) {
                System.out.println("Transaction ID: " + transaction.getTransactionId());
                System.out.println("Account Number: " + transaction.getAccountNumber());
                System.out.println("Amount: " + transaction.getAmount());
                System.out.println("Transaction Type: " + transaction.getTransactionType());
                System.out.println("Timestamp: " + transaction.getTimestamp());
                System.out.println("-----------------------------");
            }
        } else {
            System.out.println("No transactions found for the account.");
        }

    }
}
