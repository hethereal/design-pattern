package com.qiantangnotes.structural.adapter;

/**
 * 类适配器模式
 */
public class ClassAdapterPattern {
    public static void main(String[] args) {
        Computer computer = new Computer();
        //读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);
        //使用该计算机读取TF卡中的数据
        //是不能够直接读取的
        //需要定义适配器类
        String msg2 = computer.readSD(new SDAdapter());
        System.out.println(msg2);
    }
}

/**
 * 适配者类的接口
 */
interface TFCard {
    //从TF卡中读取数据
    String readTF();
    //向TF卡中写入数据
    void writeTF(String text);
}

/**
 * 适配者类的实现类
 */
class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        return "TF card read text: hello world";
    }

    @Override
    public void writeTF(String text) {
        System.out.println("TF card write text: " + text);
    }
}

/**
 * 目标接口
 */
interface SDCard {
    //从SD卡中读取数据
    String readSD();
    //向SD卡中写入数据
    void writeSD(String text);
}

/**
 * 具体的SD卡类
 */
class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "SD card read text: hello world";
    }

    @Override
    public void writeSD(String text) {
        System.out.println("SD card write text: " + text);
    }
}

/**
 * 计算机类
 */
class Computer {
    public String readSD(SDCard card) {
        if (card == null) {
            throw new NullPointerException("card is null");
        }
        return card.readSD();
    }
}

/**
 * 适配器类
 */
class SDAdapter extends TFCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "adapter read tf card";
    }

    @Override
    public void writeSD(String text) {
        System.out.println("adapter write tf card: ");
        writeTF(text);
    }
}
