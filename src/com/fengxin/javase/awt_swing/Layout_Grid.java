package com.fengxin.javase.awt_swing;

import java.awt.*;

/**
 * @author FENGXIN
 * @date 2024/6/29
 * 网格布局 计算器简单实现
 **/
public class Layout_Grid {
    public static void main (String[] args) {
        Frame frame = new Frame ();
        // 设置panel,添加文本框
        Panel panelText = new Panel ();
        panelText.add (new TextField (30));
        // 设置panel,添加操作数和运算符
        Panel panelCal = new Panel ();
        panelCal.setLayout (new GridLayout (3,5));
        for (int i = 0 ; i < 10 ; i++) {
            panelCal.add (new Button (i + ""));
        }
        char[] cal = {'+','-','*','/','='};
        for (char c : cal) {
            panelCal.add (new Button (c + ""));
        }
        // 添加panel 文本框在北区，操作在center（默认）
        frame.add (panelText,BorderLayout.NORTH);
        frame.add(panelCal);
        frame.pack ();
        frame.setVisible (true);
    }
}
