package tankGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author : 杨帅
 * @description: 坦克大战绘图区
 * @date： 2021/9/29 14:10
 */
public class MyPanel extends JPanel {
    //定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        drawTank(hero.getX(),hero.getY(),g,0,0);
//        drawTank(hero.getX()+60,hero.getY()+20,g,1,1);

    }

    /**
     * @param x      横坐标
     * @param y      纵坐标
     * @param g      画笔
     * @param direct 方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据坦克的类型设置坦克的颜色
        switch (type){
            case 0: //我们的坦克
                g.setColor(Color.cyan);//青色
                break;
            case 1: //敌人的坦克
                g.setColor(Color.yellow);//黄色
                break;

        }

        switch (direct){
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+20,y+20,20,20);
                g.drawLine(x+20,y+20,x+20,y);
                break;
            default:
                System.out.println("暂时不作处理");
        }
    }

}
