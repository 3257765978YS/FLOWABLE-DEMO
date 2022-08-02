package tankGame3;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/9/29 14:09
 */
public class Hero extends Tank {
    TankAttack tankAttack =null;
    public Hero(int x, int y) {
        super(x, y);
    }
    public void shot(){
        if(getDirect() ==0){
            tankAttack = new TankAttack(getX()+20,getY(),0);
        }else if(getDirect() ==1){
            tankAttack = new TankAttack(getX()+30+30,getY()+20+10,1);
        }else if(getDirect() ==2){
            tankAttack = new TankAttack(getX()+20,getY()+40+20,2);
        }else if(getDirect() ==3){
            tankAttack = new TankAttack(getX()+20+10,getY()+20+10,3);
        }

        new Thread(tankAttack).start();

    }
}
