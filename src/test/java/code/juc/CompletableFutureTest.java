package code.juc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

/**
 * Runnable类型的参数会忽略计算的结果，
 * Consumer是纯消费计算结果，
 * BiConsumer会组合另外一个CompletionStage纯消费，
 * Function会对计算结果做转换，
 * BiFunction会组合另外一个CompletionStage的计算结果做转换。
 */
public class CompletableFutureTest {

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        String result = CompletableFuture.supplyAsync(() -> {
            System.out.println("开始");
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(3));
            return "结束嘞";
        }).whenComplete((v, e) -> System.out.println("whenComplete:" + v)).get();
        System.out.println("main");
        System.out.println("result:" + result);
    }

    @Test
    public void test2() {
        List<String> l = new ArrayList<>();
        l.add("11111");
        l.add("22222");
        l.add("33333");
        batchProcess(l);
    }

    public static int i = 0;
    static CompletableFuture<String> findAccount(String accountId) {
        return CompletableFuture.supplyAsync(() -> {
            // mock finding account from database
            try {
                System.out.println(Thread.currentThread().getName()+":start!");
                Thread.sleep((++i)*1000);
                System.out.println(Thread.currentThread().getName()+":end!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "account" + accountId;
        });
    }

    public static void batchProcess(List<String> accountIdList) {
        // 并行根据accountId查找对应account
        List<CompletableFuture<String>> accountFindingFutureList =
                accountIdList.stream().map(CompletableFutureTest::findAccount).collect(Collectors.toList());

        // 使用allOf方法来表示所有的并行任务
        CompletableFuture<Void> allFutures =
                CompletableFuture
                        .allOf(accountFindingFutureList.toArray(new CompletableFuture[0]));
        //allFutures.join();


        // 下面的方法可以帮助我们获得所有子任务的处理结果
        CompletableFuture<List<String>> finalResults = allFutures.thenApply(v -> accountFindingFutureList.stream().map(CompletableFuture::join)
                .collect(Collectors.toList()));

        try {
            List<String> l = finalResults.get();
            System.out.println(l);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
