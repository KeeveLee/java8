package com.lk.并发.锁;

/**
 * Description:
 * 参考资料：
 * 1 https://time.geekbang.org/column/article/101244
 * Synchornized 实现同步的方式有两种：（1）修饰方法  （2）修饰代码块
 * （1）修饰方法是根据：ACC_SYNCHRONIZED
 * （2）修饰代码块是根据：monitorenter/monitorexit
 *
 *
 * 锁的优化与升级：
 * （1）锁的升级：JVM 在 JDK1.6 中引入了分级锁机制来优化 Synchronized，当一个线程获取锁时，首先对象锁将成为一个偏向锁，这样做是为了优化同一线程重复获取导致的用户态与内核态的切换问题；其次如果有多个线程竞争锁资源，锁将会升级为轻量级锁，它适用于在短时间内持有锁，且分锁有交替切换的场景；轻量级锁还使用了自旋锁来避免线程用户态与内核态的频繁切换，大大地提高了系统性能；但如果锁竞争太激烈了，那么同步锁将会升级为重量级锁。
 * （2）JIT实现锁消除/优化
 * （3 减小锁粒度：最经典的减小锁粒度的案例就是 JDK1.8 之前实现的 ConcurrentHashMap 版本。我们知道，HashTable 是基于一个数组 + 链表实现的，所以在并发读写操作集合时，存在激烈的锁资源竞争，也因此性能会存在瓶颈。而 ConcurrentHashMap 就很很巧妙地使用了分段锁 Segment 来降低锁资源竞争
 *
 *
 * Synchronized 同步锁对普通方法和静态方法的修饰有什么区别？
 * 答：普通方方法：对象锁， 静态方法：类锁
 * @author likai
 * @date 2020-05-03 18:18
 */
public class TestSynchornized {

    private volatile int num;
    private int pp;
    public int getPp(){
        return pp;
    }

    public int getNum(){
        return num;
    }

    // 关键字在实例方法上，锁为当前实例
    public synchronized void method1() {
        // code
    }

    // 关键字在代码块上，锁为括号里面的对象
    public void method2() {
        Object o = new Object();
        synchronized (o) {
            // code
        }
    }
}
