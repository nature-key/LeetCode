package juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LockConditionTest3 {

    private int maxPrdoduct=10;
    private BlockingQueue<String> product =new LinkedBlockingQueue<>(maxPrdoduct);

    private void consumer(){

        try {
            product.take();
            System.out.println("商品消费，总库存" + product.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private void  product(String str){

        try {
            product.put(str);
            System.out.println("商品生产，总资产" + product.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private class Product implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                product("商品"+i);
            }
        }
    }

    private class  Consumer implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                consumer();
            }
        }
    }

    public static void main(String[] args) {

        LockConditionTest3 ls =new LockConditionTest3();
        new Thread(ls.new Consumer()).start();
        new Thread(ls.new Product()).start();


    }


}
