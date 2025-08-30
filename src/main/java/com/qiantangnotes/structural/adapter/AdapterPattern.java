package com.qiantangnotes.structural.adapter;

public class AdapterPattern {
    public static void main(String[] args) {
        CarController car = new PoliceCarAdapter();
        car.move();
        car.audio();
        car.twinkle();
    }
}

/**
 * 汽车控制类：充当目标抽象类
 */
abstract class CarController {
    public void move() {
        System.out.println("玩具汽车移动！");
    }
    // 发出声音
    abstract void audio();
    // 灯光闪烁
    abstract void twinkle();
}

/**
 * 警笛类：充当适配者
 */
class PoliceSound {
    public void alarmSound() {
        System.out.println("发出警笛声音");
    }
}
/**
 * 警灯类：充当适配者
 */
class PoliceLamp {
    public void alarmLamp() {
        System.out.println("警灯闪烁");
    }
}

/**
 * 警车适配器：充当适配器
 */
class PoliceCarAdapter extends CarController {
    private PoliceSound sound;
    private PoliceLamp lamp;
    public PoliceCarAdapter() {
        sound = new PoliceSound();
        lamp = new PoliceLamp();
    }
    @Override
    void audio() {
        sound.alarmSound();
    }
    @Override
    void twinkle() {
        lamp.alarmLamp();
    }
}