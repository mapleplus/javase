package com.maple.javase.file.bufferedstream.object_stream;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author maple
 **/
public class Cat implements Serializable {
    private final String name;
    private final int age;
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString () {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    
    public Cat (String name , int age) {
        this.name = name;
        this.age = age;
    }
}
