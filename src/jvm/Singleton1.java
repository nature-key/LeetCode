package jvm;

/**
 * 饿汗模式
 */
public class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    public Singleton1() {
    }

    private static Singleton1 getInstance() {
        return singleton1;
    }
}
