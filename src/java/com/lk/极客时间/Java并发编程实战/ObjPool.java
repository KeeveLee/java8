package com.lk.极客时间.Java并发编程实战;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * Description: 对象池
 *
 * @author likai
 * @date 2019-08-09 11:41
 */
class ObjPool<T, R> {
    final List<T> pool;
    /**
     * 用信号量实现限流器
     */
    final Semaphore sem;

    /**
     * 构造函数
     *
     * @param size
     * @param t
     * @return
     */
    ObjPool(int size, T t) {
        pool = new Vector<T>() {
        };
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        sem = new Semaphore(size);
    }

    /**
     * 利用对象池的对象，调用 func
     */
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        sem.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 创建对象池
        ObjPool<Long, String> pool = new ObjPool<>(10, 2L);
        // 通过对象池获取 t，之后执行
        String exec = pool.exec((Long t) -> {
            System.out.println(t);
            return t.toString();
        });
        System.out.println(exec);

    }
}
