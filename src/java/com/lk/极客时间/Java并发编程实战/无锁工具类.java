package com.lk.极客时间.Java并发编程实战;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Description: 21 | 原子类：无锁工具类的典范
 *
 * @author likai
 * @date 2019-11-08 14:14
 */
public class 无锁工具类 {

    public static void main(String[] args){
        AtomicLong atomicLong = new AtomicLong(0);
        add10k(atomicLong);
        System.out.println(atomicLong);
    }


    private static void add10k(AtomicLong atomicLong){
        int idx = 0;
        while (idx++<10000){
            atomicLong.getAndIncrement();
        }

    }
}
