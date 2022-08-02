package tankGame2;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 14:08
 */
public class Tank {
    private int x;
    private int y;
    private int direct;

    private int speed = 10;

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void up(){
        y-=speed;
    }
    public void down(){
        y+=speed;
    }
    public void right(){
        x+=speed;
    }
    public void left(){
        x-=speed;
    }



}
