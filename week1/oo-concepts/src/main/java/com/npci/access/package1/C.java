package com.npci.access.package1;

// dev-C

public class C {

    A a = new A(); // HAS-A relationship

    public void cObjectMethod() {
        System.out.println("C's object method");
        //System.out.println(a.pri);
        System.out.println(a.def);
        System.out.println(a.pro);
        System.out.println(a.pub);
    }

}
