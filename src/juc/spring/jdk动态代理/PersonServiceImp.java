package juc.spring.jdk动态代理;

public class PersonServiceImp implements PersonService {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
