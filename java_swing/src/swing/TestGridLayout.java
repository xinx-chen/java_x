package src.swing;
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
