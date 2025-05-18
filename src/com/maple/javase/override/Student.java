package com.maple.javase.override;

/**
 * @author FENGXIN
 */
public class Student extends Person {
    private final int id;
    private final double score;

    public Student(String name,int age,int id, double score) {
        //构造器中super必须出现在首行
        super(name,age);
        this.id = id;
        this.score = score;
    }
    @Override
    public String message(){
        return super.message() +" " + "id="+ id + ",score="+score;
    }
}
