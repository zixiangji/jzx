package com.jzx.basic.designPatterns.singletonPattern;

/**
 * 使用静态内部类静态对象只加载一次来实现单例
 */
public class SingletonDemoThird {
    private static class SingletonHolder {
        private static SingletonDemoThird singletonDemoThird = new SingletonDemoThird();
    }

    private SingletonDemoThird() {

    }

    public static SingletonDemoThird getInstance() {
        return SingletonHolder.singletonDemoThird;
    }
}
