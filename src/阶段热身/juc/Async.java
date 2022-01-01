package 阶段热身.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Async {


    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("西水壶");
            sleep(1);
            System.out.println("烧开水");
            sleep(15);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("洗茶壶");
            sleep(1);
            System.out.println("T2:洗茶杯...");
            sleep(2);
            System.out.println("T2:拿茶叶...");
            sleep(1);
            return "龙井";
        });
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T1:拿到茶叶:" + tf);
            System.out.println("T1:泡茶...");
            return "上茶:" + tf;
        });
        System.out.println(f3.join());

    }

    private static void sleep(int time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
