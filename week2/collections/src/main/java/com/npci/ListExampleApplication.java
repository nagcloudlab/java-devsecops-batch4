package com.npci;

import com.npci.model.Account;

import java.util.*;

public class ListExampleApplication {
    public static void main(String[] args) {

        //-----------------------------------------------------------------
//        createMillionAccounts(new Vector<>()); // dynamic-array
//        createMillionAccounts(new ArrayList<>()); // dynamic-array
//        createMillionAccounts(new LinkedList<>()); // doubly-linked-list

        //-----------------------------------------------------------------

        List<Account> accounts = new ArrayList<>(5);
        accounts.add(new Account("acc_2", "name_2", 200.00));
        accounts.add(new Account("acc_1", "name_1", 100.00));
        accounts.add(new Account("acc_3", "name_3", 300.00));
        accounts.add(new Account("acc_4", "name_4", 400.00));
        accounts.add(new Account("acc_5", "name_5", 500.00));
        accounts.add(new Account("acc_5", "name_5", 500.00));

        // how to sort the accounts
        // sorting is 2 step process
        // 1. compare the 2 accounts
        // 2. swap the accounts if needed
        // sorting algorithms
        // bubble sort, selection sort, insertion sort, merge sort, quick sort, heap sort, etc.

//        Collections.sort(accounts); // by  accountNumber
//        System.out.println("After sorting:");
//        displayAccounts(accounts);

//        BalanceComparator balanceComparator = new BalanceComparator();
//        Collections.sort(accounts, balanceComparator); // by balance
//        System.out.println("After sorting by balance:");
//        displayAccounts(accounts);

        // Sort accounts by holder name ( desc )


    }

    private static void displayAccounts(List<Account> accounts) {
        System.out.println("Displaying accounts:");
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void createMillionAccounts(java.util.List<Account> accounts) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            accounts.add(new Account("acc_" + i, "name_" + i, 100.00));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to create 1 million accounts: " + (endTime - startTime) + " ms");
    }

}

class BalanceComparator implements Comparator<Account> {
    public int compare(Account a, Account b) {
        double balanceA = a.getBalance();
        double balanceB = b.getBalance();
        return Double.compare(balanceB, balanceA);
//        if (balanceA < balanceB) {
//            return -1; // a comes before b
//        } else if (balanceA > balanceB) {
//            return 1; // b comes before a
//        } else {
//            return 0; // they are equal
//        }
    }
}