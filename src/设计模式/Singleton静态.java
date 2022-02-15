package 设计模式;

public class Singleton静态 {
    private static  class  SingletonInstance{
        private static  final  Singleton静态 singleton=new Singleton静态();
    }
    private static  Singleton静态 getSingleton(){
        return SingletonInstance.singleton;
    }
}
