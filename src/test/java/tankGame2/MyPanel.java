package tankGame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author : 杨帅
 * @description: 坦克大战绘图区
 * @date： 2021/9/29 14:10
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;
    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克

        for (int i = 0; i < enemySize; i++) {
            enemyTanks.add(new EnemyTank(100*(i+1),0));
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        for (EnemyTank enemyTank : enemyTanks) {
            enemyTank.setDirect(2);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),0);
        }
        drawTank(hero.getX(),hero.getY(),g, hero.getDirect(), 1);

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
            case 0: //表示向上
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+20,x+20,y);
                break;
            case 1: //表示向右
                g.fill3DRect(x,y+10,60,10,false);
                g.fill3DRect(x,y+30+10,60,10,false);
                g.fill3DRect(x+10,y+10+10,40,20,false);
                g.fillOval(x+20,y+10+10,20,20);
                g.drawLine(x+30,y+20+10,x+30+30,y+20+10);
                break;
            case 2: //表示向下
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+40,x+20,y+40+20);
                break;
            case 3: //表示向左
                g.fill3DRect(x,y+10,60,10,false);
                g.fill3DRect(x,y+30+10,60,10,false);
                g.fill3DRect(x+10,y+10+10,40,20,false);
                g.fillOval(x+20,y+10+10,20,20);
                g.drawLine(x+30,y+20+10,x,y+20+10);
                break;
            default:
                System.out.println("暂时不作处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            hero.setDirect(0);
            hero.up();
        }else if(e.getKeyCode()==KeyEvent.VK_D){
            hero.setDirect(1);
            hero.right();
        }else if(e.getKeyCode()==KeyEvent.VK_S){
            hero.setDirect(2);
            hero.down();
        }else if(e.getKeyCode()==KeyEvent.VK_A){
            hero.setDirect(3);
            hero.left();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
