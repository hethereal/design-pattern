package com.qiantangnotes.structural.adapter;

import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 对象适配器模式
 */
public class ObjectAdapterPattern {
    public static void main(String[] args) {
        Computer02 computer = new Computer02();
        //读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl02());
        System.out.println(msg);
        //使用该计算机读取TF卡中的数据
        //是不能够直接读取的
        //需要定义适配器类
        System.out.println("=============");
        SDAdapter02 adapter02 = new SDAdapter02(new TFCardImpl());
        String msg2 = computer.readSD(adapter02);
        System.out.println(msg2);
    }
}

/**
 * 适配者类的接口
 */
interface TFCard02 {
    //从TF卡中读取数据
    String readTF();
    //向TF卡中写入数据
    void writeTF(String text);
}

/**
 * 适配者类的实现类
 */
class TFCardImpl02 implements TFCard02 {

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
interface SDCard02 {
    //从SD卡中读取数据
    String readSD();
    //向SD卡中写入数据
    void writeSD(String text);
}

/**
 * 具体的SD卡类
 */
class SDCardImpl02 implements SDCard02 {

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
class Computer02 {
    public String readSD(SDCard02 card) {
        if (card == null) {
            throw new NullPointerException("card is null");
        }
        return card.readSD();
    }
}

/**
 * 适配器类
 */
class SDAdapter02 implements SDCard02 {

    private TFCard tfCard;

    public SDAdapter02(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String text) {
        System.out.println("adapter write tf card: ");
        tfCard.writeTF(text);
    }
}
