package com.npci.lib;

import com.npci.model.Apple;
import com.npci.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TransactionsUtil {

    public static List<Transaction> filter(List<Transaction> transactions, Predicate<Transaction> filter) {
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (filter.test(transaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

}
