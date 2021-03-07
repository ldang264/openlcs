package code.juc.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized与ReentrantLock的区别
 * 前者只支持非公平锁，后者可支持公平锁
 * 后者可以指定获取锁的等待时长，超时后放弃等待
 * 后者能够关联多个条件，唤醒指定的线程
 * 前者是字节码实现，后者是API实现
 * 后者能够响应中断
 */
public class InterruptedLock {

    public static void main(String[] args) {
        InterruptedLock test = new InterruptedLock();
        new Thread(() -> {
            test.lockTest();
        }).start();
        new Thread(() -> {
            test.synchronizedTest();
        }).start();
    }

    private void lockTest() {
        // 响应中断
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        new Thread(() -> {
            try {
                lock1.lockInterruptibly();
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }, "reentrantLock1").start();

        Thread t2 = new Thread(() -> {
            try {
                lock2.lockInterruptibly();
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
            }
        }, "reentrantLock2");
        t2.start();
        t2.interrupt(); // 中断线程2，破坏死锁
    }

    private void synchronizedTest() {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(() ->{
            synchronized (o1) {
                synchronized (o2) {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));
                }
            }
        }, "synchronized1").start();
        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                synchronized (o1) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(2));
                }
            }
        }, "synchronized2");
        t2.start();
        t2.interrupt();
    }
}
