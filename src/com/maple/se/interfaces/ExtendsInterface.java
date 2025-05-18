package com.maple.se.interfaces;

/**
 * @author maple
 **/
public class ExtendsInterface {
    public static void main(String[] args) {
        monkeySon monkey = new monkeySon("悟空");
        monkey.climb();
        monkey.swimming();
    }

    interface fish {
        void swimming();
    }

    static class monkey {
        String name;

        monkey(String name) {
            this.name = name;
        }

        public void climb() {
            System.out.println(name + "会爬树");
        }

        public String getname() {
            return this.name;
        }

    }

    static class monkeySon extends monkey implements fish {

        monkeySon(String name) {
            super(name);
        }

        // 子类生来就有的技能 继承
        @Override
        public void climb() {
            System.out.println(getname() + "会爬树");
        }

        // 子类后期学习获得技能 接口
        @Override
        public void swimming() {
            System.out.println(getname() + "会游泳");
        }
    }
}

