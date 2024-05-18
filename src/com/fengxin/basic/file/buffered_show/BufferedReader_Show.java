package com.fengxin.basic.file.buffered_show;

/**
 * @author FENGXIN
 * 处理流
 * BufferedReader_Show类封装了StringReader_Show和FileReader_Show类，被封装的类称为节点流，BufferedReader_Show类称为处理流。
 * BufferedReader_Show类重写了节点流中的所有方法，并且添加了增强功能的方法。
 * 重写的方法中，由相应节点流调用
 * BufferedReader_Show类中传入的节点流对象实现多态机制，编译类型为Reader_Shoe,实际运行类型为StringReader_Show或FileReader_Show
 * StringReader_Show类和FileReader_Show类继承了Reader_Show类，Reader_Show类中定义了readString和readFile两个抽象方法
 * StringReader_Show类和FileReader_Show类实现了Reader_Show中的方法，分别实现了读取String和读取文件的功能
 * 由于多态的动态绑定机制，BufferedReader_Show中StringReader_Show或FileReader_Show对象调用方法时就调用他们自己的readString和readFile两个方法
 * 增强功能方法也是如此调用机制
 **/
public class BufferedReader_Show extends Reader_Show{
    // 封装数据源
    private final Reader_Show readerShow;
    // 构造函数
    public BufferedReader_Show(Reader_Show readerShow) {
        this.readerShow = readerShow;
    }
    // 普通方法
    @Override
    public void readString(){
        readerShow.readString ();
    }
    @Override
    public void readFile(){
        readerShow.readFile ();
    }
    // 增强读String(由StringReader对象调用)
    public void readStringPro(int num){
        System.out.println ("增强读String");
        while (--num > 0){
            readerShow.readString ();
        }
    }
    
    // 增强读文件(由FileReader对象调用)
    public void readFilePro(int num){
        System.out.println ("增强读文件");
        while (--num > 0){
            readerShow.readFile ();
        }
    }
}
