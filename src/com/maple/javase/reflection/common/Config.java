package com.maple.javase.reflection.common;


/**
 * @author maple
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
