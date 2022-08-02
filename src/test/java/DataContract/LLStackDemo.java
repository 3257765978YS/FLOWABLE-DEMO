package DataContract;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/7/1 14:55
 */
public class LLStackDemo {
    public static void main(String[] args) {
        //测试
        LLStack llStack=new LLStack();
        llStack.push(1);
        llStack.push(2);
        llStack.push(3);
        System.out.println("遍历当前栈如下所示\n：");
        llStack.list();
        System.out.println("栈长为："+llStack.getLength());
        llStack.pop();
        System.out.println("pop一个之后，栈长为："+llStack.getLength());
        System.out.println("pop一个之后，栈顶值为："+llStack.top());
        System.out.println("pop一个之后，遍历当前栈如下所示\n：");
        llStack.list();
    }
}
//定义一个实现链表的类
class LLStack{
    LLNode headNode=null;
    public LLStack(){
        headNode=new LLNode(null);//初始化
    }
    //判断是否为空
    public boolean isEmpty(){
        return headNode==null;
    }

    //入栈push
    public void push(Object data){
        //判断头结点的值为空的时候
        if(headNode.getData()==null){
            headNode.setData(data);
            //不存在头结点
        }else if(headNode==null){
            headNode=new LLNode(data);
            //存在头结点，且值不为null
        }else{
            LLNode newNode=new LLNode(data);
            newNode.setNext(headNode);
            headNode=newNode;
        }
    }

    //出栈(返回栈顶的值，并删除)
    public Object pop(){
        Object data=null;
        if(isEmpty()){
            System.out.println("栈为空，返回值为null");
            return null;
        }
        data=headNode.getData();
        headNode=headNode.getNext();
        return data;
    }

    //返回栈顶的值，但是不删除
    public Object top(){
        Object data=null;
        if(isEmpty()){
            System.out.println("栈为空，返回值为0");
            return null;
        }
        data=headNode.getData();
        return data;
    }

    //遍历
    public void list(){
        if(isEmpty()){
            System.out.println("链表为空");
        }
        LLNode temp=headNode;
        while (true){
            if (temp==null)
                break;
            System.out.println(temp.getData());

            temp=temp.getNext();
        }
    }


    //得到栈长度
    public int getLength(){
        int count=0;
        LLNode tempNode=headNode;
        //当头结点为空，并且值也为空的时候就返回0
        if(isEmpty()||tempNode.getData()==null){
            count=0;
        }else{
            while(tempNode!=null){
                count++;
                tempNode=tempNode.getNext();
            }
        }
        return count;
    }
}
//定义一个链表类
class LLNode{
    private Object data;//存放数据
    private LLNode next;//指向下一节点
    public LLNode(){

    }
    public LLNode(Object data){
        this.data=data;
    }
    public void setData(Object data){
        this.data=data;
    }
    public Object getData(){
        return data;
    }
    public void setNext(LLNode next){
        this.next=next;
    }
    public LLNode getNext(){
        return next;
    }
}

