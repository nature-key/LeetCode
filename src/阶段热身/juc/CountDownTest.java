package 阶段热身.juc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class CountDownTest {

    public static void main(String[] args) {
        final CountDownLatch downLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"3333333333");
                        downLatch.await();
                        System.out.println(Thread.currentThread().getName()+"1111111111");
                    } catch (InterruptedException e) {

                    }
                    SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
                    System.out.println(sdf.format(new Date()));


                }
            },i+"-thread").start();

        }
        System.out.println("33444444444");
       downLatch.countDown();

    }
}
