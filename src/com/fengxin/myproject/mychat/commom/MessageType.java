package com.fengxin.myproject.mychat.commom;

/**
 * @author FENGXIN
 */
public interface MessageType {
    // 定义登录成功和登录失败的常量
    String LOGIN_SUCCESS = "1";
    String LOGIN_FAIL = "2";
    String GET_ONLINE_USER = "3";
    String RETURN_ONLINE_USER = "4";
    String COMMON_MESSAGE = "5";
    String COMMON_MESSAGE_ALL ="6";
    String FILE_MESSAGE = "7";
    String PUSH_MESSAGE = "8";
    String LOGIN_FIRST = "9";
    String EXIT_LOGIN = "0";
}
