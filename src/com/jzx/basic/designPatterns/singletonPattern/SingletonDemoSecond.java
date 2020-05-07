package com.jzx.basic.designPatterns.singletonPattern;

/**
 * 懒汉模式(有延迟加载的意思)--双重校验锁（指令重排问题)
 */
public class SingletonDemoSecond {
    private static volatile SingletonDemoSecond singletonDemoSecond = null;

    private SingletonDemoSecond() {

    }

    private static SingletonDemoSecond getInstance() {
        //第一次校验
        if (singletonDemoSecond == null) {
            synchronized (singletonDemoSecond) {
                //第二次检验
                if (singletonDemoSecond == null) {
                    //创建对象，非原子操作
                    //指令重排是指JVM为了优化指令，提高程序运行效率,在不影响单线程程序执行结果的前提下,尽可能地提高并行度。
                    singletonDemoSecond = new SingletonDemoSecond();
                    //singletonDemoSecond = new SingletonDemoSecond();看似原子操作，其实不是。可以抽象成一下三步
                    //1.分配对象的内存空间
                    //memory = allocate();
                    //2.初始化对象
                    //ctorInstance(memory);
                    //3.设置instance指向刚分配的内存地址
                    //singletonDemoSecond = memory;
                    //上面三步中，2初始化对象依赖于1分配对象的内存空间，但是操作3并不依赖与2，所以JVM会进行指令的优化重排序。
                    //重新排序会1,3.2
                    //可以使用volatile关键字进行修饰，volatile的一个语义就是禁止指令的重排序优化，阻止JVM对相关代码进行指令重排序。
                }
            }
        }
        return singletonDemoSecond;
    }
}
