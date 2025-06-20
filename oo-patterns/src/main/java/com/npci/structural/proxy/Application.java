package com.npci.structural.proxy;

// design issues
// code tangling aka coupling
// code scattering aka duplication

// solution : Proxy Pattern

class Greeting {
    public void hello() {
        // main-logic
        System.out.println("Hello");
    }

    public void hi() {
        // main-logic
        System.out.println("hi");
    }
}


class Authorization {
    public void preAuthorize() {
        System.out.println("preAuthorize");
    }
}

class Emoji {
    public void printSmile() {
        System.out.println("😊");
    }
}

class GreetingProxy {
    private Greeting greeting = new Greeting(); // target
    private Authorization authorization = new Authorization(); // aspect
    private Emoji emoji = new Emoji(); // aspect

    public void hello() {
        authorization.preAuthorize();
        greeting.hello();
        emoji.printSmile();
    }

    public void hi() {
        authorization.preAuthorize();
        greeting.hi();
        emoji.printSmile();
    }

}


public class Application {
    public static void main(String[] args) {

        GreetingProxy greetingProxy = new GreetingProxy();
        greetingProxy.hello();

        System.out.println();

        greetingProxy.hi();

    }
}
