package com.npci.live;

// Open/Closed Principle (OCP)
public class God {

//    public  void manageHuman(Human human) {
//        human.eat();
//        human.sleep();
//        human.study();
//        human.work();
//    }

//    public void manageAnimal(Animal animal) {
//        animal.eat();
//        animal.sleep();
//        animal.work();
//    }

    public void manageLT(LivingThing lt) {
        lt.eat();
        lt.sleep();
        lt.work();
    }

}
