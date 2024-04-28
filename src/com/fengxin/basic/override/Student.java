package com.fengxin.basic.override;
//子类 重写父类方法
public class Student extends Person {
    private final int id;
    private final double score;

    public Student(String name,int age,int id, double score) {
        super(name,age);//构造器中super必须出现在首行
        this.id = id;
        this.score = score;
    }
    @Override
    public String message(){
        return super.message() +" " + "id="+ id + ",score="+score;
    }
}
