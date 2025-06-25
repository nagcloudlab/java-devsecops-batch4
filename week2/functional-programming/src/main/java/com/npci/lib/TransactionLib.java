package com.npci.lib;

import com.npci.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TransactionLib {

    public static List<Transaction> filter(List<Transaction> input, Predicate<Transaction> predicate) {
        //... filter logic here
        List<Transaction> filteredTransactions = new ArrayList<>();
        for (Transaction transaction : input) {
            if (predicate.test(transaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

}
