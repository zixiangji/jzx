package com.sdsc.basic.singleton;

/**
 * 使用静态内部类静态对象只加载一次来实现单例
 */
public class Singleton_Third {
    private static class SingletonHolder {
        private static Singleton_Third singleton_third = new Singleton_Third();
    }

    private Singleton_Third() {

    }

    public static Singleton_Third getInstance() {
        return SingletonHolder.singleton_third;
    }
}
