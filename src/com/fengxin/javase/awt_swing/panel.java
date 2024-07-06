package com.fengxin.javase.awt_swing;

import java.awt.*;

/**
 * @author FENGXIN
 * @date 2024/6/29
 **/
public class panel {
    public static void main (String[] args) {
        // 创建一个window对象（panel以及其他容器必须依附于window存在）
        Frame frame = new Frame ("枫");
        // 创建一个panel对象
        Panel panel = new Panel ();
        // 为panel添加文本框和按钮
        panel.add (new TextField("文本输入"));
        panel.add (new Button ("Button"));
        // 将panel添加入window
        frame.add (panel);
        // 设置window位置和大小
        frame.setBounds (100,100,500,300);
        // 设置window可见
        frame.setVisible(true);
    }
    
}
