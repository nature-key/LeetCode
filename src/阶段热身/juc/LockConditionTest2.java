package 阶段热身.juc;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest2 {

    private LinkedList<String> product = new LinkedList<>();

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int maxProduct = 10;

    private Lock consumerLock = new ReentrantLock();

    private Lock productLock = new ReentrantLock();

    private Condition notEmpty = consumerLock.newCondition();

    private Condition notFull = productLock.newCondition();


    private void product(String str) {
        productLock.lock();

        try {
            while (atomicInteger.get() == maxProduct) {
                notFull.await();
            }
            product.add(str);
            System.out.println("商品消费,总库存是" + atomicInteger.incrementAndGet());
            if (atomicInteger.get() < maxProduct) {
                notFull.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            productLock.unlock();
        }

        if (atomicInteger.get() > 0) {
            try {
                consumerLock.lockInterruptibly();
                notEmpty.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                consumerLock.unlock();
            }
        }
    }

    private String consumer() {
        String result = null;
        consumerLock.lock();

        try {
            while (atomicInteger.get() <= 0) {
                notEmpty.await();

            }
            result = product.removeLast();
            System.out.println("商品消费，总资产" + atomicInteger.decrementAndGet());
            if (atomicInteger.get() > 0) {
                notEmpty.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumerLock.unlock();
        }

        if (atomicInteger.get() < maxProduct) {
            try {
                productLock.lockInterruptibly();
                notFull.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                productLock.unlock();
            }
        }
        return result;
    }


    private class product implements  Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                product("商品"+i);
                System.out.println("生产者生产"+i);

            }
        }
    }

    private  class consumer implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                String consumer = consumer();
                System.out.println(consumer);
            }
        }
    }

    public static void main(String[] args) {
        LockConditionTest2 ls =new LockConditionTest2();
        new Thread(ls.new product()).start();
        new Thread(ls.new consumer()).start();
    }

}
