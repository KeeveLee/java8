package com.lk.极客时间.Java并发编程实战;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description: TODO
 *
 * @author likai
 * @date 2020-04-25 21:07
 */
@Slf4j
public class 线程池创建 {
    /**
     * 线程池的大小不固定，可灵活回收空闲线程，若无可回收，则新建线程；
     */
    private static final Executor cachedThreadPool = Executors.newCachedThreadPool();
    /**
     * 固定大小的线程池，当有新的任务提交，线程池中如果有空闲线程，则立即执行，否则新的任务会被缓存在一个任务队列中，等待线程池释放空闲线程
     */
    private static final Executor fixedThreadPool = Executors.newFixedThreadPool(1);
    /**
     * 定时线程池，支持定时及周期性任务执行
     */
    private static final Executor scheduledExecutor = Executors.newScheduledThreadPool(1);
    /**
     * 只创建一个线程，它只会用唯一的工作线程来执行任务，保证所有人任务按照指定顺序（FIFO-LIFO-优先级）执行
     */
    private static final Executor singleThreadExecutor = Executors.newSingleThreadExecutor();









    private final static String THREAD_POOL_MONITOR_TEMPLATE = "fetch_detail_price_thread_pool_%s_%d";

    private final static ThreadFactory THREAD_FACTORY = new NamedThreadFactory("thread_prefix_name");

    private final static int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() + 1;

    public static void main(String[] args){
        // 通过 allowCoreThreadTimeOut 设置项要求线程池：将包括“核心线程”在内的，没有任务分配的所有线程，在等待 keepAliveTime 时间后全部回收掉。
        THREAD_POOL.allowCoreThreadTimeOut(true);

        System.out.println(THREAD_POOL.getCorePoolSize());
        THREAD_POOL.setCorePoolSize(2);
        System.out.println(THREAD_POOL.getCorePoolSize());
    }
    private final static ThreadPoolExecutor THREAD_POOL =  new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            CORE_POOL_SIZE,
            60L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            THREAD_FACTORY,
            new DiscardOldestPolicy());

    static class DiscardOldestPolicy implements RejectedExecutionHandler {
        DiscardOldestPolicy() {}

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            BlockingQueue<Runnable> queue = executor.getQueue();
            if (!executor.isShutdown()) {
                executor.getQueue().poll();
                executor.execute(r);
                doMonitorAndLog(executor);
            }
        }
        private void doMonitorAndLog(ThreadPoolExecutor executor){
            log.warn(String.format(THREAD_POOL_MONITOR_TEMPLATE, "activeCount", executor.getActiveCount()));
            log.warn(String.format(THREAD_POOL_MONITOR_TEMPLATE, "maximumPoolSize", executor.getMaximumPoolSize()));
            log.warn(String.format(THREAD_POOL_MONITOR_TEMPLATE, "poolSize", executor.getPoolSize()));
            log.warn(String.format(THREAD_POOL_MONITOR_TEMPLATE, "corePoolSize", executor.getCorePoolSize()));
            log.warn(String.format(THREAD_POOL_MONITOR_TEMPLATE, "queueSize", executor.getQueue().size()));
        }
    }


    public static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum;
        private final String mPrefix;
        private final boolean mDaemo;
        private final ThreadGroup mGroup;

        public NamedThreadFactory(String prefix) {
            this(prefix, true);
        }

        public NamedThreadFactory(String prefix, boolean daemo) {
            this.mThreadNum = new AtomicInteger(1);
            this.mPrefix = prefix + "-thread-";
            this.mDaemo = daemo;
            SecurityManager s = System.getSecurityManager();
            this.mGroup = s == null ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
        }

        @Override
        public Thread newThread(Runnable runnable) {
            String name = this.mPrefix + this.mThreadNum.getAndIncrement();
            Thread ret = new Thread(this.mGroup, runnable, name, 0L);
            ret.setDaemon(this.mDaemo);
            return ret;
        }

        public ThreadGroup getThreadGroup() {
            return this.mGroup;
        }
    }


}
