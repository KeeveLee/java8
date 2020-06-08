package com.lk.并发.锁;

import lombok.Getter;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-05-14 10:58
 */
public class TestAdd10k {

    @Getter
    private long count = 0;
    @Getter
    private volatile long countV = 0;


    @Getter
    private long countS = 0;
    @Getter
    private volatile long countVS = 0;

    private void add10k(){
        int i =0;
        while (i++<10000){
            count++;
            countV++;
        }
    }

    private synchronized void add10kSync(){
        int i =0;
        while (i++<10000){
            countS++;
            countVS++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestAdd10k testAdd10k = new TestAdd10k();
        Thread t1 = new Thread(()->{
           testAdd10k.add10k();
           testAdd10k.add10kSync();
        });
        Thread t2 = new Thread(()->{
           testAdd10k.add10k();
           testAdd10k.add10kSync();
        });

        t1.start();
        t2.start();
        // 等待两个线程结束
        t1.join();
        t2.join();
        // 10000～20000
        System.out.println(testAdd10k.getCount());
        // 10000～20000
        System.out.println(testAdd10k.getCountV());
        // 20000
        System.out.println(testAdd10k.getCountS());
        // 2000
        System.out.println(testAdd10k.getCountVS());
    }
}
