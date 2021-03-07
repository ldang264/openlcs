package code.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock {

    public static void main(String[] args) {
        serializePrint();
    }

    /**
     * 使用公平锁可以实现串行化打印奇偶数
     */
    static int i = 0;
    private static void serializePrint() {
        ReentrantLock lock = new ReentrantLock(true); // 公平锁
        Runnable r = () -> {
            while (i < 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "打印" + i++);
                    LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
                } finally {
                    lock.unlock();
                }
            }
        };
        Thread t1 = new Thread(r, "线程A");
        Thread t2 = new Thread(r, "线程B");
        t1.start();
        t2.start();
    }
}
