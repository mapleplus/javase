package com.fengxin.demo;

public class String_study {
    public static void main(String[] args) {
        String string = "JAVA是一门编程语言";
        String newString = "JAVA";
        String newString2 = "J,A,V,A";
//        public int length() 获取字符串长度并返回
        int length = string.length();
        System.out.println(length);
//        public char charAr(int index) 获取某个索引位置处的字符返回
        char ch = string.charAt(0);
        System.out.println(ch);
//        public char[] toCharArray() 将字符串转换成字符数组返回
        char[] chars = string.toCharArray();
        System.out.println(chars.length);
//        public boolean equals(Object anObject) 判断两个字符串内容是否相等
        if (string.equals(newString) == true) {
            System.out.println("字符串相等");
        }
        else {
            System.out.println("字符串不相等");
        }
//        public boolean equalsIgnoreCase(String anotherString) 忽略大小写判断字符串是否相等

//        public String substring(int beginIndex, int endIndex) 根据开始和结束索引截取字符串 包前不包后
        String string1 = string.substring(0,5);
        System.out.println(string1);
//        public String substring(int beginIndex) 从传入的索引处一直截取到末尾

//        public String replace(CharSequence target,CharSequence replacement) 替换字符串
        string = string.replace(string1,newString);
        System.out.println(string);

//        public boolean contains(CharSequence s) 判断字符串中是否包含了某个字符串
        System.out.println(string.contains(newString));

//        public boolean startsWith(String prefix) 判断字符串是否以某个字符串内容开头
        System.out.println(string.startsWith(newString));

//      public String[] split(String regex) 字符串按照某个字符串内容分割 返回字符串数组
        String[] newString3 = newString2.split(",");
        for (int i = 0; i < newString2.length(); i++) {
            System.out.println(newString3[i]);
        }

    }
}
