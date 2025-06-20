package com.npci.behavior.strategy;

interface WorkStrategy {
    void doWork();
}

class WFH implements WorkStrategy {
    public void doWork() {
        System.out.println("WFH doWork");
    }
}

class Office implements WorkStrategy {
    public void doWork() {
        System.out.println("Office doWork");
    }
}

class Worker {

    WorkStrategy strategy;

    public Worker(WorkStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(WorkStrategy strategy) {
        this.strategy = strategy;
    }

    public void doWork() {
        strategy.doWork();
    }
}


// Exercise : https://refactoring.guru/design-patterns/strategy
public class Application {
    public static void main(String[] args) {


        WFH wf = new WFH();
        Office office = new Office();

        Worker worker = new Worker(wf);
        worker.doWork();
        worker.setStrategy(office);
        worker.doWork();

    }
}
