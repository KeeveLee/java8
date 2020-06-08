package com.lk.并发.锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * Description:
 * 参考资料：
 * https://time.geekbang.org/column/article/87779
 * https://time.geekbang.org/column/article/87779
 *
 * @author likai
 * @date 2020-05-03 18:53
 */
@SuppressWarnings("all")
public class TestLock {

    private double x, y;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /**
     * 读锁
     */
    private Lock readLock = lock.readLock();

    /**
     * 写锁
     */
    private Lock writeLock = lock.writeLock();

    public double read() {
        //获取读锁
        readLock.lock();
        try {
            return Math.sqrt(x * x + y * y);
        } finally {
            //释放读锁
            readLock.unlock();
        }
    }

    public void move(double deltaX, double deltaY) {
        //获取写锁
        writeLock.lock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            //释放写锁
            writeLock.unlock();
        }
    }

    class X {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        // ...
        public void m() {
            lock.lock();  // block until condition holds
            try {
                // ... method body
            } finally {
                lock.unlock();
            }
        }
    }


    public class BlockedQueue<T> {
        final Lock lock = new ReentrantLock();
        // 条件变量：队列不满
        final Condition notFull = lock.newCondition();
        // 条件变量：队列不空
        final Condition notEmpty = lock.newCondition();

        // 入队
        void enq(T x) {
            lock.lock();
            try {
                boolean 队列已满 = false;
                while (队列已满) {
                    // 等待队列不满
                    notFull.await();
                }
                // 省略入队操作...
                //入队后,通知可出队
                notEmpty.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // 出队
        void deq(){
            lock.lock();
            try {
                boolean 队列已空 = false;
                while (队列已空) {
                    // 等待队列不空
                    notEmpty.await();
                }
                // 省略出队操作...
                //出队后，通知可入队
                notFull.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final int SHARED_SHIFT = 16;
        final int SHARED_UNIT = (1 << SHARED_SHIFT);
        final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        System.out.println(SHARED_SHIFT);
        System.out.println(SHARED_UNIT);
        System.out.println(MAX_COUNT);
        System.out.println(EXCLUSIVE_MASK);
    }


    /**
     * StampLock不支持重入，不支持条件变量，线程被中断时可能导致CPU暴涨
     */
    public class Point {
        private double x, y;
        private final StampedLock s1 = new StampedLock();

        void move(double deltaX, double deltaY) {
            //获取写锁
            long stamp = s1.writeLock();
            try {
                x += deltaX;
                y += deltaY;
            } finally {
                //释放写锁
                s1.unlockWrite(stamp);
            }
        }

        double distanceFormOrigin() {
            //乐观读操作
            long stamp = s1.tryOptimisticRead();
            //拷贝变量
            double currentX = x, currentY = y;
            //判断读期间是否有写操作
            if (!s1.validate(stamp)) {
                //升级为悲观读
                stamp = s1.readLock();
                try {
                    currentX = x;
                    currentY = y;
                } finally {
                    s1.unlockRead(stamp);
                }
            }
            return Math.sqrt(currentX * currentX + currentY * currentY);
        }
    }
}
