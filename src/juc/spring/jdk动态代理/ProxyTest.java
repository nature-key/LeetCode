package juc.spring.jdk动态代理;

public class ProxyTest {


    public static void main(String[] args) {
        PersonService personService = new PersonServiceImp();
        ProxyService proxyService=new ProxyService(personService);
        PersonService proxy = (PersonService) proxyService.getProxy();
        proxy.eat();
    }
}
