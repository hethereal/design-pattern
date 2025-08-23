package com.qiantangnotes.creational;

import com.qiantangnotes.util.XMLUtil;

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        SkinFactory factory = (SkinFactory) XMLUtil.getBean();
        Button bt = factory.createButton();
        TextField tf = factory.createTextField();
        CheckBox cb = factory.createCheckBox();
        bt.display();
        tf.display();
        cb.display();
    }
}
/**
 * 按钮接口：充当抽象产品
 */
interface Button {
    void display();
}
/**
 * 充当具体产品类
 */
class SpringButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅绿色按钮");
    }
}
/**
 * 充当具体产品类
 */
class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮");
    }
}
/**
 * 文本框接口，充当抽象产品
 */
interface TextField {
    void display();
}
/**
 * 浅绿色文本输入框
 */
class SpringTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示浅绿色文本输入框");
    }
}
/**
 * 蓝色文本输入框
 */
class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示蓝色文本输入框");
    }
}
/**
 * 复选框接口：充当抽象接口
 */
interface CheckBox {
    void display();
}
/**
 * 充当具体产品
 */
class SpringCheckBox implements CheckBox {
    @Override
    public void display() {
        System.out.println("显示绿色复选框");
    }
}
/**
 * 充当具体产品
 */
class SummerCheckBox implements CheckBox {
    @Override
    public void display() {
        System.out.println("显示蓝色复选框");
    }
}
/**
 * 界面皮肤工厂接口，充当抽象工厂
 */
interface SkinFactory {
    Button createButton();
    TextField createTextField();
    CheckBox createCheckBox();
}
/**
 * 充当具体工厂
 */
class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }
    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
    @Override
    public CheckBox createCheckBox() {
        return new SpringCheckBox();
    }
}
/**
 * 充当具体工厂
 */
class SummerSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }
    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
    @Override
    public CheckBox createCheckBox() {
        return new SummerCheckBox();
    }
}