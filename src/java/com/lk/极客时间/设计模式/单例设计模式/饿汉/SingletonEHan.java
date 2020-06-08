package com.lk.极客时间.设计模式.单例设计模式.饿汉;

/**
 * Description:
 * 在类加载的时候，INSTANCE 静态实例就已经创建并初始化好了，
 * 所以，INSTANCE 实例的创建过程是线程安全的。不过，这样的实现方式不支持延迟加载
 *
 * @author likai
 * @date 2019-12-22 16:08
 */
public class SingletonEHan {
    // 有final
    private static final SingletonEHan INSTANCE = new SingletonEHan();
    private SingletonEHan(){}
    public static SingletonEHan getInstance(){
        return INSTANCE;
    }
}
