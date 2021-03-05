package code.jdk;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class CountDownLatchInJob {

    private static final Random r = new Random();

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20));
        // 1个任务开头->(10个任务同时直接)->1个任务结尾
        Callable<Integer> startJob = new SerializableJob();
        Future<Integer> startFuture = executorService.submit(startJob);
        Integer startValue = startFuture.get();
        System.out.println(System.currentTimeMillis() + ":开头的任务执行了" + startValue + "秒");

        System.out.println();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ParallelJob(i));
        }
        countDownLatch.await(); // 倒计数器，能够让线程等待计数结束才开始执行

        System.out.println();

        Callable<Integer> endJob = new SerializableJob();
        Future<Integer> endFuture = executorService.submit(endJob);
        Integer endValue = endFuture.get();
        System.out.println(System.currentTimeMillis() + "结束的任务执行了" + endValue + "秒");

        executorService.shutdown();
    }

    private static class SerializableJob implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int time = 3 + r.nextInt(2);
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(time));
            return time;
        }
    }

    private static class ParallelJob implements Callable<Integer> {

        private int index;

        public ParallelJob(int index) {
            this.index = index;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(System.currentTimeMillis() + ":批处理任务并行处理" + index + "开始");
            int time = 2 + r.nextInt(5);
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(time));
            System.out.println(System.currentTimeMillis() + ":批处理任务并行处理" + index + "完成，执行了" + time + "秒");
            countDownLatch.countDown();
            return time;
        }
    }
}
