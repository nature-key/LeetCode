package 阶段热身.juc;

import java.util.concurrent.*;

public class ExecutorTest {

    ExecutorService
            executor = Executors.newFixedThreadPool(3);

    private void test() {
        // 异步向电商S1询价
        Future<String> f1 = executor.submit(() -> {
            sleep(1);
            System.out.println(" 计算完F1");
            return "f1";
        });
        Future<String> f2 = executor.submit(() -> {
            sleep(10);
            System.out.println("计算完F2");
            return "f2";
        });
        Future<String> f3 = executor.submit(() -> {
            sleep(2);
            System.out.println("计算完F3");
            return "f3";
        });

        BlockingQueue<String> bq =new LinkedBlockingDeque<>();

        try {
            String s1 = f1.get();
            String s2 = f2.get();
            String s3 = f3.get();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);

//            executor.execute(()->{
//                try {
//                    String s1 = f1.get();
//                    System.out.println("获取计算结果"+s1);
//                    bq.put(s1);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
//            executor.execute(()->{
//                try {
//                    String s2 = f2.get();
//                    System.out.println("获取计算结果"+s2);
//                    bq.put(s2);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
//            executor.execute(()->{
//                try {
//                    String s3 = f3.get();
//                    System.out.println("获取计算结果"+s3);
//                    bq.put(s3);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            });
//
//            for (int i=0; i<3; i++) {
//                String r = bq.take();
//
//                System.out.println("从阻塞队列获取："+r);
//                executor.execute(()->{
//                    System.out.println("保存阻塞队列结果"+r);
//                });
//            }

        } catch (Exception e) {
            e.printStackTrace();

        }finally {
            executor.shutdown();
        }
    }

    public static void main(String[] args) {
        ExecutorTest t =new ExecutorTest();
        t.test();
    }


    // 异步向电商S2询价Future f2 = executor.submit( ()->getPriceByS2());
    // 异步向电商S3询价Future f3 = executor.submit( ()->getPriceByS3());
    // 获取电商S1报价并保存r=f1.get();executor.execute(()->save(r));
    // 获取电商S2报价并保存r=f2.get();executor.execute(()->save(r));
    // 获取电商S3报价并保存 r=f3.get();executor.execute(()->save(r));
    private static void sleep(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
