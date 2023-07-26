package src.swing;

import java.awt.*;

//第一个GUI界面
public class TestFrame {
    //frame,jdk，看源码
    public static void main(String[] args){
        Frame frame = new Frame("我的第一个Java图形界面窗口");
        //设置可见性
        frame.setVisible(true);
        //设置窗口大小
        frame.setSize(400,400);
        //color
        frame.setBackground(new Color(85,150,68));
        //弹出初始位置
        frame.setLocation(200,200);
        //设置大小固定
        frame.setResizable(false);
    }
}
