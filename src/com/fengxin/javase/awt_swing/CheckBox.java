package com.fengxin.javase.awt_swing;

import java.awt.*;

/**
 * @author FENGXIN
 * @date 2024/6/29
 **/
public class CheckBox {
    public static void main (String[] args) {
        Frame frame = new Frame ();
        frame.setBounds (100,100,500,300);
        CheckboxGroup checkboxGroup = new CheckboxGroup ();
        Checkbox checkbox1 = new Checkbox ("male",checkboxGroup,true);
        Checkbox checkbox2 = new Checkbox ("female",checkboxGroup,false);
        Checkbox checkbox = new Checkbox ("married");
        frame.add (checkbox1);
        frame.add (checkbox2);
        frame.add (checkbox);
        frame.pack ();
        frame.setVisible (true);
    }
}
