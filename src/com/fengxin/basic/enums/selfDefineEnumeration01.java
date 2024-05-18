package com.fengxin.basic.enums;

/**
 * @author FENGXIN
 **/
public class selfDefineEnumeration01 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
    }
}

/**
 * Season
 */
class Season {

    private String name;
    private String desc;
    // 定义固定对象 暴露对象，final + static底层优化
    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season SUMMER = new Season("夏天", "炎热");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season WINTER = new Season("冬天", "寒冷");

    // 将构造器私有化 并且不设置set方法
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "The name:" + this.name + " The Desc:" + this.desc;
    }

}
