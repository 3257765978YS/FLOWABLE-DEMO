package tankGame;

import javax.swing.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 14:12
 */
public class YsTankGame01 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        YsTankGame01 game01 = new YsTankGame01();
    }
    public YsTankGame01(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
