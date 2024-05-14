package com.fengxin.basic.enums;

/**
 * @author FENGXIN
 * @data 2024.5.2
 **/
public class selfDefineEnumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
        System.out.println(Season2.SUMMER);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.WINTER);
        System.out.println ();
        System.out.println ("name()：返回当前对象名，子类不能重写");
        System.out.println(Season2.SPRING.name());
        System.out.println ();
        System.out.println ("ordinal()：返回位置，默认从0开始");
        System.out.println("WINTER's position:" + Season2.WINTER.ordinal());
        System.out.println ();
        System.out.println ("values()：返回包含所有枚举常量的一个数组");
        Season2[] values_ = Season2.values();
        for (Season2 season2 : values_) {
            System.out.println(season2);
        }
        System.out.println ();
        System.out.println ("valueOf()：将字符串转换成枚举常量（常量须存在类中）");
        Season2 value = Season2.valueOf("SUMMER");
        System.out.println(value);
        System.out.println ();
        System.out.println ("compareTo：比较两个枚举常量的位置");
        System.out.println(Season2.WINTER.compareTo(Season2.SPRING));
    }
}

/**
 * Season
 */
enum Season2 {
    // 有多个枚举对象用 `,`间隔，最后`;` 结尾
    // 枚举对象必须放在枚举类体的行首
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷"),
    // 使用无参构造器创建枚举对象，实参列表和小括号都可以省略
    WHAT
    ;

    private String name;
    private String desc;

    Season2() {
    }

    // 将构造器私有化 并且不设置set方法
    private Season2(String name, String desc) {
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
