package com.npci.live;

public class Application {
    public static void main(String[] args) {

        God god = new God();

        Human human = new Human();
        Animal animal = new Animal();
        Robot robot = new Robot();

        god.manageLT(human);
        System.out.println();
        god.manageLT(animal);
        System.out.println();
        god.manageLT(robot);

    }
}
