package com.sdsc.basic.designPatterns.singletonPattern;

/**
 * 单例模式(确保一个类只有一个实例，而且自动实例化并向整个系统提供这个实例。它提供全局访问的方法)
 */
public class SingletonDemoFirst {
    //饿汉模式。构造函数私有化，然后创建出实例，最后向外界提供获取该实例的方法
    private static final SingletonDemoFirst demoFirst = new SingletonDemoFirst();
    private SingletonDemoFirst() {
    }
    public static SingletonDemoFirst getInstance() {
        return demoFirst;
    }
}
