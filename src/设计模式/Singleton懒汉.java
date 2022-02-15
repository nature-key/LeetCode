package 设计模式;

public class Singleton懒汉 {

    private  static  volatile  Singleton singleton;

    public Singleton懒汉() {
    }

    public static Singleton getSingleton() {

        if (singleton==null) {
            synchronized (Singleton懒汉.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}
