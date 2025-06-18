package com.npci.access.package2;


// dev-D

import com.npci.access.package1.A;

public class E {

    A a = new A(); // HAS-A relationship

    public void eObjectMethod() {
        System.out.println("E's object method");
        //System.out.println(a.pri);
        //System.out.println(a.def);
        //System.out.println(a.pro);
        System.out.println(a.pub);
    }

}
