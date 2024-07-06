package com.fengxin.javase.awt_swing;

import java.awt.*;


/**
 * @author FENGXIN
 * @date 2024/6/29
 * 设置一个窗口
 **/
public class window {
    public static void main (String[] args) {
        // 设置一个window对象
        Frame frame = new Frame ("枫");
        // 设置window位置、大小
        frame.setLocation (200,200);
        frame.setSize (500,300);
        Panel panel = new Panel ();
        Panel panel1 = new Panel ();
        Choice choice = new Choice ();
        choice.add ("a");
        choice.add ("b");
        choice.add ("c");
        frame.add (choice);
        List list = new List (2,true);
        list.add ("apple");
        list.add ("banana");
        list.add ("cccc");
        CheckboxGroup cg = new CheckboxGroup ();
        Checkbox checkbox1 = new Checkbox ("xxx",cg,false);
        Checkbox checkbox2 = new Checkbox ("yyy",cg,false);
        Checkbox checkbox3 = new Checkbox ("zzz",cg,false);
        // checkbox1.setCheckboxGroup (cg);
        // checkbox2.setCheckboxGroup (cg);
        // checkbox3.setCheckboxGroup (cg);
        panel1.add (checkbox1);
        panel1.add (checkbox2);
        panel1.add (checkbox3);
        
        panel.add (choice);
        panel.add (list);
        // 设置window可见
        frame.add (panel,BorderLayout.NORTH);
        frame.add (panel1);
        frame.setVisible (true);
    }
}
