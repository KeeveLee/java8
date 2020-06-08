package com.lk.极客时间.Java并发编程实战;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 25 | CompletionService：如何批量执行异步任务
 * 实现一个询价的代码
 * 谁先放到LinkedBlockingQueue 里谁先执行
 *
 * @author likai
 * @date 2019-11-08 19:57
 */
public class TestCompletionService {

    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(10, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TestCompletionService testCompletionService = new TestCompletionService();
        testCompletionService.askSupplier();

    }

    private void askSupplier() throws InterruptedException, ExecutionException {

        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(THREAD_POOL_EXECUTOR, new LinkedBlockingDeque<>(3));
        // 异步向电商S1询价
        completionService.submit(this::getPriceByS1);
        // 异步向电商S2询价
        completionService.submit(this::getPriceByS2);
        // 异步向电商S3询价
        completionService.submit(this::getPriceByS3);

        for (int i = 0; i < 3; i++) {
            Integer integer = completionService.take().get();
            THREAD_POOL_EXECUTOR.execute(() ->saveToDB(integer));
        }


    }

    private int getPriceByS1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return 1;
    }

    private int getPriceByS2() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        return 2;
    }

    private int getPriceByS3() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return 3;
    }

    private void saveToDB(int i){
        System.out.println("save sucess: " + i);
    }
}
