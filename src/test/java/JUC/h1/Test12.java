package JUC.h1;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @author : 杨帅
 * @description:
 * @date： 2022/2/15 14:40
 */
@Slf4j
public class Test12 {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(()->{
                messageQueue.put(new Message(id,"值"+id));
            },"生产者"+i).start();
        }

        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message m = messageQueue.take();
            }
        },"消费者").start();
    }
}

//消息队列类 ，java线程之间通信
@Slf4j
class MessageQueue{
    private LinkedList<Message> list = new LinkedList<>();

    //队列容量
    private int capicity;

    public MessageQueue(int capicity) {
        this.capicity = capicity;
    }

    //获取消息
    public Message take(){
        synchronized (list){
            while(list.isEmpty()){
                try {
                    log.debug("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //从队列头部获取消息并返回
            Message message = list.removeFirst();
            log.debug("已消费消息 {}",message);
            list.notify();
            return message;
        }
    }

    //存入消息
    public void put(Message message){
        synchronized (list){
            //检查对象是否已满
            while(list.size() == capicity){
                try {
                    log.debug("队列已满，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            log.debug("已生产消息 {}",message);
            list.notify();
        }
    }
}

@Slf4j
class Message{
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}

