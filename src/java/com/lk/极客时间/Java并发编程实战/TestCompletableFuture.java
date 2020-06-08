package com.lk.极客时间.Java并发编程实战;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 24 | CompletableFuture：异步编程没那么难
 *
 * @author likai
 * @date 2019-11-08 17:49
 */
public class TestCompletableFuture {

    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));

    public static void main(String[] args) {
        TestCompletableFuture testCompletableFuture = new TestCompletableFuture();
//        testCompletableFuture.fun();
        testCompletableFuture.fun2();
    }

    private void fun() {
        //任务1：洗水壶->烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶。。。");
            sleep(1, TimeUnit.SECONDS);
        }, THREAD_POOL_EXECUTOR);
        //任务2：洗茶壶->洗茶杯->拿茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);
            System.out.println("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);
            System.out.println("T2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            return "龙井";
        }, THREAD_POOL_EXECUTOR);
        //任务3：任务1和任务2完成后执行：泡茶
        CompletableFuture f3 = f1.thenCombine(f2, (temp, tf) -> {
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶...");
            return "上茶:" + tf;
        });
        //等待任务3执行结果
        System.out.println(f3.join());

    }

    private void fun2() {
        CompletableFuture<Integer>
                f0 = CompletableFuture
                .supplyAsync(()->7/0)
                .thenApply(r->r*10)
                .exceptionally(e->{
                    System.out.println(e);
                    return 19999;
                });


        System.out.println(f0.join());
    }

    private void sleep(int t, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class SafeDateformat{
        static final ThreadLocal<DateFormat> THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        static DateFormat get(){
            return THREAD_LOCAL.get();
        }
    }
}
