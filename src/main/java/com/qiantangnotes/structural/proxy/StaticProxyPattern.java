package com.qiantangnotes.structural.proxy;

/**
 * 静态代理模式
 * 火车站卖票案例
 */
public class StaticProxyPattern {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}

/**
 * 定义一个卖火车票的标准
 * 抽象主题类
 */
interface SellTicket {
    void sell();
}

/**
 * 具体主题类
 */
class Station implements SellTicket {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}

/**
 * 代理主题类
 */
class ProxyPoint implements SellTicket {

    private Station station = new Station();

    @Override
    public void sell() {
        System.out.println("代售点收取服务费");
        station.sell();
    }
}
