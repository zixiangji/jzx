package com.sdsc.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
    /**
     * 注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。
     * 元注解有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
     *
     * @Target
     * Target 是目标的意思，@Target 指定了注解运用的地方。标记这个注解应该是哪种 Java 成员。
     *
     * 类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了
     * 比如只能张贴到方法上、类上、方法参数上等等。
     *  @Target 有下面的取值
     *         ElementType.ANNOTATION_TYPE  可以给一个注解进行注解
     *         ElementType.CONSTRUCTOR      可以给构造方法进行注解
     *         ElementType.FIELD            可以给属性进行注解
     *         ElementType.LOCAL_VARIABLE   可以给局部变量进行注解
     *         ElementType.METHOD           可以给方法进行注解
     *         ElementType.PACKAGE          可以给一个包进行注解
     *         ElementType.PARAMETER        可以给一个方法内的参数进行注解
     *         ElementType.TYPE             可以给一个类型进行注解，比如类、接口、枚举
     *
     * @Retention
     *     @Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
     *     RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
     *     RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
     *     RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
     *
     * @Documented
     *     顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。
     *
     * @Inherited
     *     Inherited 是继承的意思，但是它并不是说注解本身可以继承，
     *     而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
     *
     *
     *
     * 新版本注解
     * @SafeVarargs - Java 7 开始支持，忽略任何使用参数为泛型变量的方法或构造函数调用产生的警告。
     * @FunctionalInterface - Java 8 开始支持，标识一个匿名函数或函数式接口。
     * @Repeatable - Java 8 开始支持，标识某注解可以在同一个声明上使用多次。
     */



}
