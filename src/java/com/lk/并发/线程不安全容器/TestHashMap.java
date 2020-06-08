package com.lk.并发.线程不安全容器;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * https://www.jianshu.com/p/59a2d8e6f296
 *
 * @author likai
 * @date 2020-05-08 09:48
 */
public class TestHashMap {
    private static Map<Integer, String> map = new HashMap<>(32);
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(20);
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            EXECUTOR.submit(() -> {
               map.put(finalI, "test:"+ finalI);
            });
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(map);
        //{2=test:2, 3=test:3, 5=test:5, 6=test:6, 7=test:7, 8=test:8, 9=test:9}
    }
}
