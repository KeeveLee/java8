package com.lk.极客时间.设计模式.单例设计模式.懒汉;

/**
 * Description:
 * 双重检查这种实现方式，只要 instance 被创建之后，即便再调用 getInstance() 函数也不会再进入到加锁逻辑中了。
 * 所以，这种实现方式解决了懒汉式并发度低的问题。
 *
 * @author likai
 * @date 2020-04-17 14:25
 */
public class SingletonLanHan {
    // 没有final
    private static SingletonLanHan singletonLanHan;
    private SingletonLanHan(){}
    public static SingletonLanHan getInstance(){
        if (null == singletonLanHan){
            synchronized (SingletonLanHan.class){
                if (null == singletonLanHan){
                    singletonLanHan = new SingletonLanHan();
                }
            }
        }
        return singletonLanHan;
    }
}
