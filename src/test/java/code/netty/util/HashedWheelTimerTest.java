package code.netty.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {

    public static void main(String[] args) {
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(timeout -> {
            execute(timeout);
        }, 1, TimeUnit.SECONDS);
    }

    private static void execute(Timeout timeout) {
        System.out.println(new Date());
        timeout.timer().newTimeout(timeout1 -> {
            execute(timeout1);
        }, 1, TimeUnit.SECONDS);
    }
}
