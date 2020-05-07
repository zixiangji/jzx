package com.jzx.basic.designPatterns.factoryPattern;

/**
 * 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。
 * 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        if (args.length != 1) {
            return;
        }
        //可以传参数，根据参数知道需要创建具体的产品
        Factory factory = null;
        Vehicle vehicle = null;
        String str = args[0];
        if (str.equals("car")) {
            factory = new CarFactory();
        } else if (str.equals("bus")) {
            factory = new BusFactory();
        } else if (str.equals("bicycle")) {
            factory = new BicycleFactory();
        }
        if (factory != null) {
            vehicle = factory.produce();
            vehicle.run();
        }
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
