package juc.spring.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyService implements InvocationHandler {


    private Object target;

    public ProxyService(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("洗手");
        Object result = method.invoke(target, args);
        System.out.println("洗碗");
        return result;
    }

    public  Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(),this);
    }

}
