package com.lk.极客时间.设计模式.单例设计模式.饿汉;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性
 */
public enum SingletonEnum {
    //
    instance;
    public List<String> list = null;

    SingletonEnum(){
        list = new ArrayList<>();
    }

    public static SingletonEnum getInstance(){
        return instance;
    }
}
