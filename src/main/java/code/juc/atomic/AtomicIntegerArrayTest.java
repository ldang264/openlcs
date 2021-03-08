package code.juc.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    public static void main(String[] args) {
        // 10个元素的数组
        AtomicIntegerArray arr = new AtomicIntegerArray(10);
        Thread[] ts = new Thread[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            ts[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    arr.getAndIncrement(j % arr.length()); // 各位自增10000
                }
            });
            ts[i].start();
        }
        try {
            for (int i = 0; i < arr.length(); i++) {
                ts[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arr); // 因为是线程安全，所以最终都是10000
    }
}
