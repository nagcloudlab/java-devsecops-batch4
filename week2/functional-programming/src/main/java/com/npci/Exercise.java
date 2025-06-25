package com.npci;

import com.npci.model.Trader;
import com.npci.model.TraderTransaction;

import java.util.Arrays;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<TraderTransaction> transactions = Arrays.asList(
                new TraderTransaction(brian, 2011, 300),
                new TraderTransaction(raoul, 2012, 1000),
                new TraderTransaction(raoul, 2011, 400),
                new TraderTransaction(mario, 2012, 710),
                new TraderTransaction(mario, 2012, 700),
                new TraderTransaction(alan, 2012, 950)
        );

        //----------------------------------------------------------
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        // Query 2: What are all the unique cities where the traders work?
        // Query 3: Find all traders from Cambridge and sort them by name.
        // Query 5: Are there any trader based in Milan?
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        //----------------------------------------------------------


        // Query 1
        transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
                .forEach(System.out::println);
        // Query 2
        transactions
                .stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        // Query 3
        transactions
                .stream()
                .map(TraderTransaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
        // Query 5
        boolean isTraderInMilan = transactions
                .stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("Is there any trader based in Milan? " + isTraderInMilan);
        // Query 6
        transactions
                .stream()
                .filter(t -> "Milan".equals(t.getTrader().getCity()))
                .forEach(t -> t.getTrader().setCity("Cambridge"));

    }
}
