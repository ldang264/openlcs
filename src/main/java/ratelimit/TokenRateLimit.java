package ratelimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 令牌桶：定义每秒的令牌个数，比如100个，那每10ms放入一个令牌。
 * 用户线程来取令牌，取完就阻塞或失败
 */
public class TokenRateLimit {

    private final int permits; // 一秒内的令牌总个数

    private volatile AtomicInteger currentPermits; // 当前剩余总个数

    public TokenRateLimit(int permits) {
        if (permits <= 0) throw new IllegalStateException(permits + " <= 0!");

        this.permits = permits;
        init();
    }

    private void init() {
        // 当前剩余总个数初始化为默认最大数
        this.currentPermits = new AtomicInteger(permits);

        // 开启一个线程，一直向令牌桶中放令牌
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (currentPermits.get() == permits) {
                System.out.println("令牌满了");
            } else {
                System.out.println(System.currentTimeMillis() + "放入令牌");
                currentPermits.incrementAndGet();
            }
        }, 0, 1000000 / permits, TimeUnit.MICROSECONDS);
    }

    public void acquire() {
        while (currentPermits.get() == 0) { // 令牌空了的时候，直接自旋等待令牌桶添加
            //
        }
        currentPermits.decrementAndGet(); // 发一个令牌
        System.out.println(System.currentTimeMillis() + "获得令牌");
    }

    public static void main(String[] args) {
        TokenRateLimit tokenRateLimit = new TokenRateLimit(10); // 一百毫秒放一个
        for (int i = 0; i < 20; i++) {
            tokenRateLimit.acquire();
        }
    }
}
