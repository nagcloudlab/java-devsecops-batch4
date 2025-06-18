package com.npci.access;

import com.npci.access.package1.A;
import com.npci.access.package1.B;

public class Application {
    public static void main(String[] args) {

        A a = new A();
        a.aObjectMethod();

        B b = new B();
        b.bObjectMethod();

    }
}
