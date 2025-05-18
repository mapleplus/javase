package com.maple.javase.reflection.common;


/**
 * @Description 类路径配置
 * @Author maple
 * @Date 2025-05-18 23:16
 **/
public enum Config {
    /**
     *  cry
     */
    CRY("cry"),
    /**
     *  com.maple.javase.reflection.base.Cat
     */
    CAT("com.maple.javase.reflection.base.Cat");

    private final String key;

    Config(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
