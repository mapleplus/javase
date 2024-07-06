package com.fengxin.javase.awt_swing;

import java.awt.*;

/**
 * @author FENGXIN
 * @date 2024/6/29
 * 边框布局
 **/
public class Layout_Border {
    public static void main (String[] args) {
        Frame frame = new Frame ("枫");
        // 设置垂直、水平间距
        frame.setLayout (new BorderLayout (30,10));
        // 设置边框布局
        frame.add (new Button ("NORTH BUTTON"),BorderLayout.NORTH);
        frame.add (new Button ("WEST BUTTON"),BorderLayout.WEST);
        frame.add (new Button ("CENTER BUTTON"),BorderLayout.CENTER);
        frame.add (new Button ("EAST BUTTON"),BorderLayout.EAST);
        frame.add (new Button ("SOUTH BUTTON"),BorderLayout.SOUTH);
        frame.pack ();
        frame.setVisible (true);
    }
}
