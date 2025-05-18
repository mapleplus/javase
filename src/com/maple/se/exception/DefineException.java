package com.maple.se.exception;

/**
 * @author maple
 **/
public class DefineException {

    public static void main(String[] args) {
        int year = -5;
        if (year <= 0) {
            // 把信息传给异常类的构造器
            throw new YearException("年份不能是负数！");
        }
    }

    static class YearException extends RuntimeException {
        YearException(String year) {
            // 传递给父类信息
            super(year);
        }
    }
}