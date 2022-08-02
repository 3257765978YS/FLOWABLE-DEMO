package tankGame3;

import javax.swing.*;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 14:12
 */
public class YsTankGame03 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        YsTankGame03 game01 = new YsTankGame03();
    }
    public YsTankGame03(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
