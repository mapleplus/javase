package com.fengxin.javase.awt_swing;

import java.awt.*;

/**
 * @author FENGXIN
 * @date 2024/6/29
 * 流式布局
 **/
public class Layout_Flow {
    public static void main (String[] args) {
        Frame frame = new Frame ();
        // 设置对齐方式，垂直、水平间距
        frame.setLayout (new FlowLayout (FlowLayout.CENTER,50,50));
        // 设置按钮
        for (int i = 0 ; i < 100 ; i++) {
            frame.add(new Button ("button" + i));
        }
        // 设置按钮最佳大小
        frame.pack ();
        frame.setVisible (true);
    }
}
