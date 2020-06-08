package com.lk.并发.JUC;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Description: https://time.geekbang.org/column/article/89461
 * 让多个线程步调一致
 * case：对账系统
 * <p>
 * while(存在未对账订单){
 * // 查询未对账订单
 * pos = getPOrders();
 * // 查询派送单
 * dos = getDOrders();
 * // 执行对账操作
 * diff = check(pos, dos);
 * // 差异写入差异库
 * save(diff);
 * }
 *
 * @author likai
 * @date 2020-05-05 10:19
 */
@SuppressWarnings("ALL")
public class TestCountDownLatchAndCyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        TestCountDownLatchAndCyclicBarrier test = new TestCountDownLatchAndCyclicBarrier();
        test.parallelOrderGetWithJoin();

//        test.parallelOrderGetWithCountDownLatch();
        test.parallelOrderGetWithCyclicBarrier();

    }

    /**
     * 并行化getPOrders() 与 getDOrders()
     */
    private void parallelOrderGetWithJoin() throws InterruptedException {

        AtomicReference<String> pos = new AtomicReference<>();
        AtomicReference<String> dos = new AtomicReference<>();
        // 查询未对账订单
        Thread t1 = new Thread(() -> {
            pos.set(getPOrder());
        });
        t1.start();
        //查询派送单
        Thread t2 = new Thread(() -> {
            dos.set(getDOrder());
        });
        t2.start();
        // 等待t1,t2结束
        t1.join();
        t2.join();
        // 执行对账操作
        String diff = check(pos.get(), dos.get());
        save(diff);
    }

    /**
     *
     * CountDownLatch 主要解决一个线程等待多个线程的场景，可以类比一个bus要等待所有的乘客到齐后才能出发
     * 实现原理：
     * 1 利用AQS的state 做计数
     * 2 unsafe的cas 设置计数
     *
     * @throws InterruptedException
     */
    private void parallelOrderGetWithCountDownLatch() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        AtomicReference<String> pos = new AtomicReference<>();
        AtomicReference<String> dos = new AtomicReference<>();
        // 初始化计数器为2
        CountDownLatch countDownLatch = new CountDownLatch(2);
        executor.execute(() -> {
            pos.set(getPOrder());
            countDownLatch.countDown();
        });
        executor.execute(() -> {
            dos.set(getDOrder());
            countDownLatch.countDown();
        });
        // 等待两个线程的结果
        countDownLatch.await();
        String diff = check(pos.get(), dos.get());
        save(diff);
    }

    /**
     * CyclicBarrier是一组线程之间互相等待，可以类比几个人开车必须都到齐了才出发
     * 实现原理：
     * 1 ReentrantLock
     * 2 count值计数
     */
    private void parallelOrderGetWithCyclicBarrier() {
        // 订单队列
        Vector<String> pos = new Vector<>();
        // 派送单队列
        Vector<String> dos = new Vector<>();
        /**
         * 执行回调的线程池
         * 1.使用线程池是为了异步操作，否则回掉函数是同步调用的，也就是本次对账操作执行完才能进行下一轮的检查。
         * 2.线程数量固定为1，防止了多线程并发导致的数据不一致，
         *   因为订单和派送单是两个队列，只有单线程去两个队列中取消息才不会出现消息不匹配的问题。
         */
        Executor executor = Executors.newSingleThreadExecutor();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            // 当计数器为0时候执行回调函数
            executor.execute(() -> check(pos, dos));
        });

        checkAll(pos, dos, cyclicBarrier);
    }

    private void check(Vector<String> pos, Vector<String> dos) {
        String p = pos.remove(0);
        String d = dos.remove(0);
        String diff = check(p, d);
        save(diff);
    }

    private void checkAll(Vector<String> pos, Vector<String> dos,final CyclicBarrier cyclicBarrier){
        // 循环查询订单库
        Thread T1 = new Thread(() -> {
            // 查询订单库
            pos.add(getPOrder());
            // 等待
            try {
                System.out.println("t1:"+cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        );
        T1.start();
        // 循环查询运单库
        Thread T2 = new Thread(() -> {
            // 查询运单库
            dos.add(getDOrder());
            // 等待
            try {
                System.out.println("t2:"+cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        });
        T2.start();
    }


    private String getPOrder() {
        return "pos";
    }

    private String getDOrder() {
        return "dos";
    }

    private String check(String pos, String dos) {
        return pos + "===" + dos;
    }

    private void save(String diff) {
        System.out.println(diff);
    }
}
