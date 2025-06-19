package com.npci.chain;

interface Handler {
    void setNext(Handler next);
    void handleRequest(double amount);
}

class FiveHundredHandler implements Handler {
    private Handler nextHandler;

    public void setNext(Handler next) {
        this.nextHandler = next;
    }

    public void handleRequest(double amount) {
    }
}
class TwoHundredHandler implements Handler {
    private Handler nextHandler;

    public void setNext(Handler next) {
        this.nextHandler = next;
    }

    public void handleRequest(double amount) {
        // e.g., if amount is 200, then this handler will handle 200
        // e.g., if amount is 400, then next handler will be called
    }
}


public class Application {

    public static void main(String[] args) {
        Handler fiveHundredHandler = new FiveHundredHandler();
        Handler twoHundredHandler = new TwoHundredHandler();
        // chain-1
        fiveHundredHandler.setNext(twoHundredHandler);

        fiveHundredHandler.handleRequest(1000);

    }

}
