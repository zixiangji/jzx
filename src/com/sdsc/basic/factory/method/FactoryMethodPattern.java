package com.sdsc.basic.factory.method;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Factory carFactory = new CarFactory();
        Vehicle car = carFactory.produce();
        car.run();
        Factory busFactory = new BusFactory();
        Vehicle bus = busFactory.produce();
        bus.run();
        Factory bicycleFactory = new BicycleFactory();
        Vehicle bicycle = bicycleFactory.produce();
        bicycle.run();
    }
}

interface Factory {
    Vehicle produce();
}

class CarFactory implements Factory {

    @Override
    public Vehicle produce() {
        return new Car();
    }
}

class BusFactory implements Factory {

    @Override
    public Vehicle produce() {
        return new Bus();
    }
}

class BicycleFactory implements Factory {

    @Override
    public Vehicle produce() {
        return new Bicycle();
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
