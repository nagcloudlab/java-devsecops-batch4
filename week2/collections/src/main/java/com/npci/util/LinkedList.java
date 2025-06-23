package com.npci.util;


// Collection + Iterator => Iterable Collection
// Collection => data structure that holds a group of objects
// Iterator => object that allows you to traverse through a collection

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    // Algorithm(s)
    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }
    public void add(int index, E data) {
        Node newNode = new Node(data);
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (newNode.getNext() == null) {
            tail = newNode;
        }
    }
    public int size() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            current = current.getNext();
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return current.getData();
    }
    public Iterator<E> iterator(){
        class It implements Iterator<E> {
            Node current = head;
            public boolean hasNext() {
                return current != null;
            }
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements in the list");
                }
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        }
        return new It();
    }

}
