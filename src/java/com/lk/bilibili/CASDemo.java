package com.lk.bilibili;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-01-27 20:38
 */
public class CASDemo {

    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2020) + "," + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "," + atomicInteger.get());

        int andIncrement = atomicInteger.getAndIncrement();
    }
}
