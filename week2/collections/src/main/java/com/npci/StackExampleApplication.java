package com.npci;

import java.util.Stack;

public class StackExampleApplication {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("foo");
        stack.push("bar");
        stack.push("baz");

        // System.out.println(stack.peek());

        while (!stack.isEmpty()) {
            String item = stack.pop();
            System.out.println(item);
        }

    }

}
