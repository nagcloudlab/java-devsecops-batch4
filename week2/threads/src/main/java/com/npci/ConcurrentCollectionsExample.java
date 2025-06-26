package com.npci;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsExample {
    public static void main(String[] args) {

        Vector<String> vector = new Vector<>(); // thread-safe collection
        ArrayList<String> list = new ArrayList<>(); // not thread-safe collection
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(); // use with attention to performance

        HashMap<String, String> hashMap = new HashMap<>(); // not thread-safe collection
        Map<String, String> synchronizedMap = Collections.synchronizedMap(hashMap);

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        //....

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);

        //...


    }
}
