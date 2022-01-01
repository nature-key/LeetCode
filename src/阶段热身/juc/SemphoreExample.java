package 阶段热身.juc;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemphoreExample {


    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);

        for (int index = 0; index < 20; index++) {

            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                            Thread.sleep((long) Math.random());
                        System.out.println("到达一个");
                        semaphore.release();

                        System.out.println("剩余所烧令牌"+semaphore.availablePermits());

                    } catch (Exception e) {
                        System.out.println(e);
                    }finally {

                    }
                }
            };
            executorService.execute(run);
        }
        executorService.shutdown();
    }

}
