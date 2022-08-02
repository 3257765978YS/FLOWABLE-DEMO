package demo.Painting;

import javax.swing.*;
import java.awt.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 11:03
 */
public class DrawCircle extends JFrame{
    private MyPanel mp =null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.setVisible(true);
    }

}

class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g); //调用父类的方法完成初始化
        System.out.println("paint方法被调用~~");
//        g.drawOval(50,50,100,100);
        g.drawRect(10,20,10,60);
        g.drawOval(20,40,20,20);
        g.drawRect(40,20,10,60);
        g.drawRect(20,30,20,40);
        g.drawLine(30,40,30,10);
        g.setColor(Color.black);
        g.fillRect(10,20,10,60);
        g.fillRect(40,20,10,60);
        g.fillRect(20,30,20,40);

    }
}
