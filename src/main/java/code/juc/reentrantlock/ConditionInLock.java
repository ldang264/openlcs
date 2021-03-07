package code.juc.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用condition实现ArrayBlockingQueue
 */
public class ConditionInLock {

    private List<Integer> list;

    private int capacity;

    private Lock lock;

    private Condition empty;

    private Condition full;

    private Random r = new Random();

    public ConditionInLock(int len) {
        this.list = new ArrayList<>(len);
        this.capacity = len;
        lock = new ReentrantLock();
        empty = lock.newCondition();
        full = lock.newCondition();
    }

    public void offer(int i) {
        lock.lock();
        try {
            while (this.list.size() == capacity) {
                System.out.println("------队列满------");
                full.await();
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50 + r.nextInt(1000)));
            }
            this.list.add(i);
            empty.signal();
            System.out.println("加入" + i);
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50 + r.nextInt(100)));
        } catch (InterruptedException e) {
            full.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int poll() {
        lock.lock();
        int val = -1;
        try {
            while (this.list.size() == 0) {
                System.out.println("------队列空------");
                empty.await(); // 空了
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50 + r.nextInt(100)));
            }
            val = this.list.remove(0);
            System.out.println("弹出" + val);
            full.signal();
            LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(50 + r.nextInt(200)));
        } catch (InterruptedException e) {
            empty.signal();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return val;
    }

    public static void main(String[] args) {
        ConditionInLock test = new ConditionInLock(10);
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.offer(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.poll();
            }
        }).start();
    }
}
