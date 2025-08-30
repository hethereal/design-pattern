package com.qiantangnotes.structural.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxyPatternByCGLib {
    public static void main(String[] args) {
        ProxyFactory02 factory02 = new ProxyFactory02();
        Station03 object = factory02.getProxyObject();
        object.sell();
    }
}

/**
 * 真实具体类
 */
class Station03 {
    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * 代理对象工厂类：用来获取代理对象
 */
class ProxyFactory02 implements MethodInterceptor {

    //声明火车站对象
    private Station03 station03 = new Station03();

    public Station03 getProxyObject() {
        //创建Enhancer对象，类似与JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(Station03.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        Station03 proxyObject = (Station03) enhancer.create();

        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB收费");
        Object object = methodProxy.invoke(station03, objects);
        return object;
    }
}
