package com.npci;

import com.npci.model.Account;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExampleApplication {
    public static void main(String[] args) {

        //-----------------------------------------------------------------
//        createMillionAccounts(new TreeSet<>()); // red-black tree ( one of balanced binary search tree )
//        createMillionAccounts(new HashSet<>()); // hash table
//        createMillionAccounts(new LinkedHashSet<>()); // hash table with linked list
        //-----------------------------------------------------------------


        Account account1 = new Account("acc_1", "name_1", 100.00);
        System.out.println("account1.hashCode() = " + account1.hashCode());
        Account account11 = new Account("acc_1", "name_1", 100.00);
        System.out.println("account2.hashCode() = " + account11.hashCode());
        Account account2 = new Account("acc_2", "name_2", 100.00);
        Account account3 = new Account("acc_3", "name_3", 100.00);
        Account account4 = new Account("acc_4", "name_4", 100.00);

        System.out.println(account1.equals(account2));

//        Set<Account> accounts = new TreeSet<>(); // sorted set, object must be comparable else provide comparator
        //Set<Account> accounts = new HashSet<>(); // unordered set, object must implement equals and hashCode
        Set<Account> accounts = new LinkedHashSet<>(); // maintains insertion order , object must implement equals and hashCode
        accounts.add(account1);
        accounts.add(account11); // This will not be added if using HashSet or TreeSet, as it is a duplicate based on equals and hashCode
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        displayAccounts(accounts);


    }

    private static void displayAccounts(Set<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    private static void createMillionAccounts(java.util.Set<Account> accounts) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            accounts.add(new Account("acc_" + i, "name_" + i, 100.00));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to create 1 million accounts: " + (endTime - startTime) + " ms");
    }

}
