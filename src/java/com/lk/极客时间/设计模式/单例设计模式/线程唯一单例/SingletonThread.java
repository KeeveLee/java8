package com.lk.极客时间.设计模式.单例设计模式.线程唯一单例;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * 线程唯一单例的代码实现很简单，如下所示。
 * 在代码中，我们通过一个 HashMap 来存储对象，其中 key 是线程 ID，value 是对象。这样我们就可以做到，
 * 不同的线程对应不同的对象，同一个线程只能对应一个对象。
 * 实际上，Java 语言本身提供了 ThreadLocal 工具类，可以更加轻松地实现线程唯一单例。不过，ThreadLocal 底层实现原理也是基于下面代码中所示的 HashMap。
 * @author likai
 * @date 2020-04-17 15:44
 */
public class SingletonThread {

    private static final ConcurrentHashMap<Long, SingletonThread> instaances = new ConcurrentHashMap<>();

    private SingletonThread(){}
    public static SingletonThread getInstance(){
        long curThreadId = Thread.currentThread().getId();
        instaances.putIfAbsent(curThreadId, new SingletonThread());
        return instaances.get(curThreadId);
    }

}
