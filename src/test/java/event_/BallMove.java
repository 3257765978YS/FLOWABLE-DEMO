package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 14:49
 */
public class BallMove extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }
    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

class MyPanel extends JPanel implements KeyListener {
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    /**
     * 监听字符输入
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 按下某个键
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            y+=10;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y-=10;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x-=10;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=10;
        }

        //让面板重绘
        this.repaint();
    }

    /**
     * 松开某个键
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
