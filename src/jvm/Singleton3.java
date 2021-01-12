package jvm;

public class Singleton3 {

    public Singleton3() {
    }

    private static class Singleton {
        private static Singleton3 singleton = new Singleton3();
    }

    private static Singleton3 getInstance() {
        return Singleton3.Singleton.singleton;
    }

}
