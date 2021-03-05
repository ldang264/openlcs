package code.jdk;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class VolatileNotAtomic {

    /**
     * volatile具有可见性和有序性，但不具有原子性
     * 通过在编译的二进制字节码中增加Lock前缀指令和缓存一致性协议，实现可见性
     * 通过CPU内存屏障，防止指令重排序，实现有序性
     */
    private volatile int i;

    public static void main(String[] args) {
        VolatileNotAtomic test = new VolatileNotAtomic();
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                60,
                TimeUnit.SECONDS,
                new SynchronousQueue<>());
        for (int j = 0; j < 10000; j++) {
            executorService.execute(() -> {
                test.i++;
            });
        }
        executorService.shutdown();
        System.out.println(test.i); // i基本不会等于10000
    }
}
