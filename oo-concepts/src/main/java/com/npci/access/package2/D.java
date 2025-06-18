package com.npci.access.package2;

import com.npci.access.package1.A;

// author: dev-D

// D is-a A
public class D extends A {

    public void dObjectMethod() {
        System.out.println("D's object method");
        //System.out.println(pri);
        //System.out.println(def);
        System.out.println(pro);
        System.out.println(pub);
    }

}
