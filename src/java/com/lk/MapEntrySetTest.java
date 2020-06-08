package com.lk;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-02-21 18:33
 */
public class MapEntrySetTest {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            8,
            8,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10), new ThreadFactoryBuilder()
            .setNameFormat("Test_Future").build(),new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<String> submit = THREAD_POOL_EXECUTOR.submit(() -> "test");
        System.out.println(submit.get());
        System.out.println(submit.get());
        THREAD_POOL_EXECUTOR.shutdown();
    }



}
