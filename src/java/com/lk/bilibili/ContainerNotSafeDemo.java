package com.lk.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 集合类不安全问题
 * java.util.ConcurrentModificationException
 * @author likai
 * @date 2020-02-01 11:11
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(list);
//            }, "T" + i).start();
//        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                
            }, "T" + i).start();
        }

    }
}
