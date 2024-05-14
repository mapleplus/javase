package com.fengxin.basic.exception;

/**
 * @author FENGXIN
 * @data 2024.5.10
 **/
public class DefineException {
    //自定义异常
    public static void main(String[] args) {
        int YEAR = -5;
        if (YEAR <= 0) {
            // 把信息传给异常类的构造器
            throw new YearException("年份不能是负数！");
        }
    }
}
// 定义一个异常类
class YearException extends RuntimeException {
    YearException(String year) {
        // 传递给父类信息
        super(year);
    }
}