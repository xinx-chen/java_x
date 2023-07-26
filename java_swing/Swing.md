#Swing

## 1、简介

* GUi核心技术：swing AWT

1、界面不美观

2、需要jre环境

* 为什么学习？

1、可以自己写小工具

2、工作可能会维护到swing界面，概率很小

3、了解MVC架构，了解监听



## 2、AWT

### 2.1、AWT介绍

1. 包含了很多类和接口 GUI：图形用户界面
2. 元素：窗口、按钮、文本框
3. java.awt

![image-20230724102734545](E:\github\ph\image-20230724102734545.png)

### 2.2、组件和容器

#### 1. Frame 弹窗

```
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
```

>![swing1](E:\github\ph\swing1.png)
>
>问题：发现窗口无法关闭，停止Java程序！
>
>尝试回顾封装

```
import java.awt.*;
public class TestFrame2 {
    public static void main(String[] args){
        //展示多个窗口 new
        MyFrame myFrame1 = new MyFrame(100,100,200,200,Color.blue);
        MyFrame myFrame2 = new MyFrame(300,100,200,200,Color.yellow);
        MyFrame myFrame3 = new MyFrame(100,300,200,200,Color.red);
        MyFrame myFrame4 = new MyFrame(300,300,200,200,Color.MAGENTA);
    }

}
class MyFrame extends Frame{
    static int id = 0;//可能存在多个窗口，需要一个计数器
    //构造器
    public MyFrame(int x,int y,int w,int h,Color color){
        super("MyFrame"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
```

> ![QQ截图20230725083942](E:\github\ph\QQ截图20230725083942.png)

#### 2、panel 面板

解决了关闭事件

```
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//面板 panel 可以看成是一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();

        //设置布局
        frame.setUndecorated(true);
        frame.setLayout(null);

        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(40, 161, 35));
        //panel设置坐标，相对于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(193,15,60));
        //frame.add(panel)
        frame.add(panel);
        frame.setVisible(true);
        //监听事件，监听窗口关闭事件 System.exit(0);
        //适配器模式：
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //结束程序
                System.exit(0);
            }
        });


    }
}
```

#### 3、布局管理器

* 流式布局

  ```
  import java.awt.*;
  
  public class TestFlowLayout {
      public static void main(String[] args) {
          Frame frame = new Frame();
      //组件-按钮
          Button button1 = new Button("button1");
          Button button2 = new Button("button2");
          Button button3 = new Button("button3");
          //设置为流式布局
          //frame.setLayout(new FlowLayout());
          frame.setLayout(new FlowLayout(FlowLayout.RIGHT));
          frame.setSize(200,200);
          frame.add(button1);
          frame.add(button2);
          frame.add(button3);
          frame.setVisible(true);
  
      }
  }
  ```

  ![QQ截图20230725104802](E:\github\ph\QQ截图20230725104802.png)

* 东西南北中

  ```
  import java.awt.*;
  public class TestBorderLayout {
      public static void main(String[] args) {
         Frame frame=  new Frame("TestBorderLayout");
  
         Button east = new Button("east");
          Button west = new Button("west");
          Button south = new Button("south");
          Button north = new Button("north");
          Button center = new Button("center");
  
          frame.add(east,BorderLayout.EAST);
          frame.add(west,BorderLayout.WEST);
          frame.add(south,BorderLayout.SOUTH);
          frame.add(north,BorderLayout.NORTH);
          frame.add(center,BorderLayout.CENTER);
          frame.setSize(200,200);
          frame.setVisible(true);
      }
  }
  ```

  ![QQ截图20230725104921](E:\github\ph\QQ截图20230725104921.png)

* 表格布局

```
import java.awt.*;
public class TestGridLayout {
    public static void main(String[] args) {
        Frame frame=new Frame();

        Button btn1= new Button("1");
        Button btn2= new Button("2");
        Button btn3= new Button("3");
        Button btn4= new Button("4");
        Button btn5= new Button("5");
        Button btn6= new Button("6");
        frame.setLayout(new GridLayout(3,2));
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);

        frame.pack();//Java函数
        frame.setVisible(true);
    }
}
```

![QQ截图20230725105621](E:\github\ph\QQ截图20230725105621.png)

#### 4、事件监听

```
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String[] args) {
        //按下按钮，触发事件
        Frame frame = new Frame();
        Button button= new Button();
        //因为，addActionListener()需要一个ActionListener,所以我们需要构造一个ActionListener
        MyActionListener myActionListener=new MyActionListener();
        button.addActionListener(myActionListener);
        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        windowClose(frame);//关闭窗体
        frame.setVisible(true);

    }
//关闭窗体事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
//事件监听
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("a");
    }
}
```

