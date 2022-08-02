package tankGame3;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/30 15:41
 */
public class TankAttack implements Runnable {
    int x;
    int y;
    int direct = 0;
    int speed = 2;

    boolean isLive = true;

    public TankAttack(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            if (!(x >= 0 && x <= 100 && y >= 0 && y <= 750)) {
                isLive = false;
                break;
            }
        }
    }
}
