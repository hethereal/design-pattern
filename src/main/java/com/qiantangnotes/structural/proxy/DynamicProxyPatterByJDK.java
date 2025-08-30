package com.qiantangnotes.structural.proxy;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class DynamicProxyPatterByJDK {
    public static void main(String[] args) {
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //使用Factory对象的方法获取代理对象
        SellTicket02 proxyObject = factory.createProxyObject();
        proxyObject.sell();

        //通过Arthas查看代理类的结构
        System.out.println(proxyObject.getClass());
        while (true) {}
    }
}

/**
 * 定义一个卖火车票的标准
 * 抽象主题类
 */
interface SellTicket02 {
    void sell();
}

/**
 * 具体主题类
 */
class Station02 implements SellTicket02 {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * 获取代理对象的工厂类
 */
class ProxyFactory {

    //声明对象目标对象
    private Station02 station02 = new Station02();

    public SellTicket02 createProxyObject() {
        return (SellTicket02) Proxy.newProxyInstance(
                station02.getClass().getClassLoader(),
                station02.getClass().getInterfaces(),
                /*
                    proxy 代理对象，在invoke方法中基本不用
                    method 对接口中的方法进行封装的method对象
                    args：调用方法的实际参数
                    return： void -> null 其他对应具体的值
                 */
                (proxy, method, args) -> {
                    System.out.println("invoke方法执行了");
                    //执行目标对象的方法
                    Object obj = method.invoke(station02, args);
                    System.out.println("代收点收取费用：JDK动态代理");
                    return obj;
                }
        );
    }
}

