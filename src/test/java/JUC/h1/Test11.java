package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/15 13:29
 */
public class Test11 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }

        Thread.sleep(1000);
        for (Integer id : MailBox.getIds()) {
            new Postman(id,"内容"+id).start();
        }
    }
}

@Slf4j
class People extends Thread{
    @Override
    public void run() {
        //收信
        GuardedObject guardedObject = MailBox.createGuardedObject();
        log.debug("开始收信id:{}",guardedObject.getId());
        Object mail = guardedObject.get(5000);
        log.debug("收到信 id:{}，内容:{}",guardedObject.getId(),mail);
    }
}

@Slf4j
class Postman extends Thread{
    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject guardedObject = MailBox.getGuardedObject(id);
        log.debug("送信 id：{}，内容：{}", id,mail);
        guardedObject.complete(mail);
    }
}

class MailBox{
    private static final Map<Integer, GuardedObject> boxes = new Hashtable<>();

    private static int id = 1;

    public static GuardedObject getGuardedObject(int id){
        return boxes.remove(id);
    }

    //产生唯一ID
    private static synchronized int generateId(){
        return id++;
    }

    public static GuardedObject createGuardedObject(){
        GuardedObject go = new GuardedObject(generateId());
        boxes.put(go.getId(),go);
        return go;
    }

    public static Set<Integer> getIds(){
        return boxes.keySet();
    }
}

class GuardedObject {
    private int id;
    //结果
    private Object response;

    public GuardedObject(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    //获取结果
    //timeout
    //表示要等待多久
    public Object get(long timeout) {
        synchronized (this) {
            //开始时间
            long begin = System.currentTimeMillis();
            //经历时间
            long passedTime = 0;
            while (response == null) {
                long waitTime = timeout - passedTime;
                //经历的时间超过最大时间，退出循环(下一轮等待时间小于等于0，退出循环)
                if (waitTime<=0) {
                    break;
                }
                try {
                    this.wait(waitTime); //虚假唤醒:complete()方法参数传入Null
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedTime = System.currentTimeMillis() - begin;
            }
        }
        return response;
    }

    public void complete(Object response) {
        synchronized (this) {
            this.response = response;
            this.notifyAll();
        }
    }
}
