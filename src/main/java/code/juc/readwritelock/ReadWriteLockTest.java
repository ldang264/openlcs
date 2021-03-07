package code.juc.readwritelock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁，适合读多写少的场景
 *     读   写
 * 读  不   阻塞
 * 写  阻塞 阻塞
 */
public class ReadWriteLockTest {

    private int value; // 读写对象

    private Lock readLock;

    private Lock writeLock;

    public ReadWriteLockTest(Lock readLock, Lock writeLock) {
        this.readLock = readLock;
        this.writeLock = writeLock;
    }

    public Object handleRead() {
        try {
            readLock.lock();
            Thread.sleep(1000);
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            readLock.unlock();
        }
    }

    public void handleWrite(int value) {
        try {
            writeLock.lock();
            Thread.sleep(1000);
            this.value = value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        Lock reentrantLock = new ReentrantLock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReadWriteLockTest test =
                new ReadWriteLockTest(readWriteLock.readLock(), readWriteLock.writeLock());
                //new ReadWriteLockTest(reentrantLock, reentrantLock); // 读写锁执行两秒，重入锁因为读读冲突要执行20秒
        Runnable read = test::handleRead;
        Runnable write = () -> {
            test.handleWrite(r.nextInt());
        };
        for (int i = 0; i < 18; i++) {
            new Thread(read).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(write).start();
        }
    }
}
