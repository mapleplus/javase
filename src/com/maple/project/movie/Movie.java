package com.maple.project.movie;

/**
 * @author maple
 */
public class Movie {
    private int id;
    private String name;
    private Double price;
    private String actor;
    private String info;

    public Movie() {
    }

    public Movie(int id , String name , Double price , String actor , String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actor = actor;
        this.info = info;
    }

    public void setId (int id) {
        this.id = id;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice (Double price) {
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
