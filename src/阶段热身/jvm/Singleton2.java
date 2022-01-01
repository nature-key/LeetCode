package 阶段热身.jvm;

public class Singleton2 {

    private  static  volatile Singleton2 singleton2 = null;

    public Singleton2() {
    }

    private static Singleton2 getInstance() {
        if (singleton2 != null) {
            synchronized (Singleton2.class) {
                if (singleton2 != null) {
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }

}
