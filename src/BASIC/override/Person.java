package BASIC.override;
//父类
public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String message(){
        return "姓名：" + name + "，年龄：" + age;
    }
}
