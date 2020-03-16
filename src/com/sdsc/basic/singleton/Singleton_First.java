package com.sdsc.basic.singleton;

/**
 * 单例模式(确保一个类只有一个实例，而且自动实例化并向整个系统提供这个实例。它提供全局访问的方法)
 */
public class Singleton_First {
    //饿汉模式。构造函数私有化，然后创建出实例，最后向外界提供获取该实例的方法
    private static final Singleton_First SINGLETON_FIRST = new Singleton_First();
    private Singleton_First() {
    }
    public static Singleton_First getInstance() {
        return SINGLETON_FIRST;
    }
}
