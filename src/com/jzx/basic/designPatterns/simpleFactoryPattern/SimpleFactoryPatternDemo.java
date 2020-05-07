package com.sdsc.basic.designPatterns.simpleFactoryPattern;

public class SimpleFactoryPatternDemo {

    public static void main(String[] args) {
        Vehicle vehicle = Factory.produce("bus");
        vehicle.run();
    }
}

class Factory {
    public static Vehicle produce(String type) {
        Vehicle vehicle = null;
        if (type.equals("car")) {
            vehicle = new Car();
            return vehicle;
        }
        if (type.equals("bus")) {
            vehicle = new Bus();
            return vehicle;
        }
        if (type.equals("bicycle")) {
            vehicle = new Bicycle();
            return vehicle;
        }
        return vehicle;
    }
}

interface Vehicle {
    void run();
}

class Car implements Vehicle {

    @Override
    public void run() {
        System.out.println("car run......");
    }
}

class Bus implements Vehicle {

    @Override
    public void run() {
        System.out.println("bus run......");
    }
}

class Bicycle implements Vehicle {

    @Override
    public void run() {
        System.out.println("bicycle run......");
    }
}
