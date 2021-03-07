package code.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量Semaphore可以允许多个线程同时访问
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphore semp = new Semaphore(5); // 一次执行5个线程
        Runnable r = () -> {
            try {
                semp.acquire();
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getId() + " done!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semp.release();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            executorService.submit(r);
        }
        executorService.shutdown();
    }
}
