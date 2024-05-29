package com.fengxin.myproject.javase.movie;

/**
 * @author FENGXIN
 */
public class Movie {
    private int id;
    private String name;
    private double price;
    private String actor;
    private String info;
//  默认构造器
    public Movie() {
    }
//  有参构造器
    public Movie(int id , String name , double price , String actor , String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actor = actor;
        this.info = info;
    }

    //  设置---获取数据
    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getPrice () {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public String getActor () {
        return actor;
    }

    public void setActor (String actor) {
        this.actor = actor;
    }

    public String getInfo () {
        return info;
    }

    public void setInfo (String info) {
        this.info = info;
    }
}
