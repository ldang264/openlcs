package code.juc.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    Thread.sleep(6000);
                } else {
                    System.out.println("get lock failed!!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();
    }
}
