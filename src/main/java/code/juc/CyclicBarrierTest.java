package code.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 *
 */
public class CyclicBarrierTest {
    private static class Soldier implements Runnable {

        private String soldier;

        private final CyclicBarrier cyclic;

        public Soldier(String soldier, CyclicBarrier cyclic) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                // 等待士兵到齐
                cyclic.await();
                doWork();
                // 等待所有士兵完成工作
                cyclic.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }
    }

    private static class BarrierRun implements Runnable {

        boolean flag;

        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (!flag) {
                System.out.println("司令:[士兵" + N + "个，集合完毕！]");
                flag = true;
            } else {
                System.out.println("司令:[士兵" + N + "个，任务完成！]");
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldiers = new Thread[N];
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(false, N));
        System.out.println("集合队伍！");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道");
            allSoldiers[i] = new Thread(new Soldier("士兵" + i, cyclic));
            allSoldiers[i].start();
        }
    }
}
