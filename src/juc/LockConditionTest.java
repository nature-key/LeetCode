package juc;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {

    private LinkedList<String> product = new LinkedList<>();

    private int maxInventory = 10;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    private void product(String str) {
        lock.lock();
        try {
            while (product.size() >= maxInventory) {
                condition.await();
            }
            product.add(str);
            System.out.println("放入库存,总库存是" + product.size());
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void consume() {
        lock.lock();

        try {
            while (product.size() <= 0) {
                condition.await();
            }
            product.removeLast();
            System.out.println("消费一个商品 总库存" + product.size());
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private class Product implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
              product("商品"+i);
            }
        }
    }

    private class Consume implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                consume();
            }
        }
    }


    public static void main(String[] args) {

        LockConditionTest test =new LockConditionTest();

        new Thread(test.new Product()).start();
        new Thread(test.new Consume()).start();
        new Thread(test.new Product()).start();
        new Thread(test.new Consume()).start();




    }


}
