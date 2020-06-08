package com.lk.极客时间.设计模式.单例设计模式.饿汉;

/**
 * Description:
 * 静态内部类
 * 比双重检测更加简单的实现方法，那就是利用 Java 的静态内部类。它有点类似饿汉式，但又能做到了延迟加载
 * SingletonHolder 是一个静态内部类，当外部类 SingletonStatic 被加载的时候，并不会创建 SingletonHolder 实例对象。
 * 只有当调用 getInstance() 方法时，SingletonHolder 才会被加载，这个时候才会创建 instance。
 * instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
 * 所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 * @author likai
 * @date 2020-04-17 14:32
 */
public class SingletonStatic {

    // 没有final
    private static SingletonStatic instance;

    private SingletonStatic(){}

    private static class SingletonHolder{
        private static final SingletonStatic instance = new SingletonStatic();
    }

    public static SingletonStatic getInstance(){
        return SingletonHolder.instance;
    }

}
