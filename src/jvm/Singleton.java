package jvm;

public class Singleton {

    public Singleton() {
    }

    private static class LazyHolder {
        static Singleton singleton = new Singleton();
        static {
            System.out.println("LazyHolder.clint");
        }
    }

    private static Object getInstance(boolean flag) {
        if (flag) {
            return new LazyHolder[2];
        }
        return LazyHolder.singleton;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----------");
        getInstance(false);
    }

}
