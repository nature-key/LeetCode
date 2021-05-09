package juc;

/**
 * 懒汉模式
 */
public class Singleton {

    private static  volatile  Singleton singleton = null;

    public Singleton() {
    }

    private Singleton  getSingletonInstance(){

        if (singleton==null) {

            synchronized (Singleton.class){
                if (singleton==null) {
                    singleton = new Singleton();
                }
            }
        }
        return  singleton;
    }
}
