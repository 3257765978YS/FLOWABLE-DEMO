package DataContract;

import java.util.Stack;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/4/25 15:54
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        SingleLinkedList singleLinkedList1=new SingleLinkedList();
        singleLinkedList1.add(hero2);
        singleLinkedList1.add(hero3);
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
        System.out.println("原来的链表情况~");
        singleLinkedList.list();

//        reverseList(singleLinkedList.getHead());
//        System.out.println("反转后的链表情况~");
//        singleLinkedList.list();
        System.out.println("测试逆序打印单链表,没有改变链表本身的结构~~");
        reversePrint(singleLinkedList.getHead());
//        DataContract.HeroNode newHeroNode=new DataContract.HeroNode(1,"小宋","及时雨@@");
//        singleLinkedList.update(newHeroNode);
//        System.out.println("修改后的单链表为:\n");
//        singleLinkedList.list();
//        singleLinkedList.del(1);
//        singleLinkedList.del(2);
//        singleLinkedList.del(3);
//        singleLinkedList.del(4);
//        System.out.println("删除后的链表为：");
//        singleLinkedList.list();
//        singleLinkedList.search(3);

//        System.out.println("有效的节点个数:"+getLength(singleLinkedList.getHead()));

//        DataContract.HeroNode res=findLastIndexNode(singleLinkedList.getHead(), 2);
//        System.out.println("res="+res);
    }

    /**
     *@Author: 杨帅
     *@Description: 查找倒数第k个节点 【新浪面试题】
     * 1.编写一个方法，接收head节点，同事接收一个index
     * 2.index表示是倒数第index个节点
     * 3.先把链表从头到尾遍历，得到链表的总的长度getLength
     * 4.得到size后，我们从链表的第一个开始遍历（size-index）个
     *@Date:15:26 2021/4/28
     * @param head
     * @param index
     *@return
     */
    public static HeroNode findLastIndexNode(HeroNode head,int index){
        if (head.next==null)
            return null;
        //第一次遍历得到链表的个数
        int size=getLength(head);
        //第二次遍历 size-index位置，就是我们倒数的第k个节点
        //先做一个index校验
        if (index<=0||index>size){
            return null;
        }
        //定义辅助变量，for循环定位到倒数的index
        HeroNode cur=head.next;
        for (int i=0;i<size-index;i++) //比如size=3,index=1，则后移3-1=2位
            cur=cur.next;
        return cur;
    }

    /**
     *@Author: 杨帅
     *@Description: 实现单链表逆序打印 【百度面试题】
     * 可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，从而实现逆序打印的效果
     *@Date:13:58 2021/6/7
     * @param
     *@return
     */
    public static void reversePrint(HeroNode head){
        if(head.next==null){
            return;//空链表，不能打印
        }
        //创建一个栈，将各个节点压入栈
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode cur=head.next;
        //将链表的所有节点压入栈
        while(cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        //将栈中的节点进行打印，pop出栈
        while(stack.size()>0){
            System.out.println(stack.pop());//特点：先进后出
        }
    }

    public static void conbineList(HeroNode head){
        HeroNode cur =head.next;
        HeroNode next=null;//指向当前节点[cur]的下一个节点
    }

    /**
     *@Author: 杨帅
     *@Description: 单链表的反转 【腾讯面试题】
     *@Date:16:44 2021/4/28
     * @param head
     *@return
     */
    public static void reverseList(HeroNode head){
        //如果当前链表为空，或者只有一个节点，无需反转，直接return
        if(head.next==null||head.next.next==null)
            return ;
        //定义一个辅助指针（变量），帮助我们遍历原来的链表
        HeroNode cur=head.next;
        HeroNode next=null;//指向当前节点[cur]的下一个节点
        HeroNode reverseHead=new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取出，放在reverseHead节点的最前端
        //核心逻辑如下
        while (cur!=null){
            next=cur.next;//先暂时保存当前节点的下一个节点，后面要用
            cur.next=reverseHead.next;//将cur的下一个节点指向reverseHead的最前端
            reverseHead.next=cur;//将反转头结点指向cur节点,即将cur连接到reverseHead上
            cur=next;//后移cur
        }
        //将head.next指向reverseHead.next，大功告成
        head.next=reverseHead.next;
    }

    /**
     *@Author: 杨帅
     *@Description: 获取有效节点个数
     *@Date:15:17 2021/4/28
     *@param head
     *@return
     */
    //获取单链表的节点个数
    public static int getLength(HeroNode head){
        if(head.next==null)
            return 0;
        int length=0;
        //定义一个辅助变量
        HeroNode cur=head.next;
        while(cur!=null){
            length++;
            cur=cur.next; //遍历
        }
        return length;
    }
}
 class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");


    //返回头节点
    public HeroNode getHead(){
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp=head;
        while (true){
            if(temp.next==null) //遍历结束
                break;
            temp=temp.next;
        }
        temp.next=heroNode;
    }
    //按照编号顺序添加
    public void addByOrder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;//标识，默认为false表示不存在该编号
        while (true){
            if (temp.next==null)  //遍历结束
                break;
            if (temp.next.no > heroNode.no)  //
                break;
            else if (temp.next.no == heroNode.no){
                flag=true; //编号已存在
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.printf("该编号 %d 的英雄已存在，不可插入！\n",+heroNode.no);
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    //修改节点信息
    public void update(HeroNode newHeroNode){
        if(head.next==null)
            System.out.println("链表为空！");
        HeroNode temp=head.next;
        boolean flag=false; //表示是否找到该节点

        //循环遍历寻找节点
        while (true){
            if(temp==null)
                break;
            if (temp.no== newHeroNode.no){ //找到该节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){ //找到该节点则进行更新操作
            temp.name= newHeroNode.name;
            temp.nickName= newHeroNode.nickName;
        }else
            System.out.printf("未找到编号为%d的英雄\n",+newHeroNode.no);
    }

    //删除链表
    public void del(int no){
        HeroNode temp=head;
        boolean flag=false;
        while(true){
            if(temp.next==null)
                break;
            if (temp.next.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.printf("要删除的编号为%d的节点不存在\n",+no);
        }
    }

    //查询节点
    public void search(int no){
        HeroNode temp=head.next;
        boolean flag=false;
        while(true){
            if(temp==null)
                break;
            if (temp.no==no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.printf("编号为%d的英雄信息如下\n",+no);
            System.out.println(temp);
        }else {
            System.out.printf("要查询的编号为%d的英雄不存在\n",+no);
        }
    }


    //显示链表
    public void list(){
        if(head.next==null){
            System.out.println("链表为空");
        }
        HeroNode temp=head.next;
        while (true){
            if (temp==null)
                break;
            System.out.println(temp);

            temp=temp.next;
        }
    }
}

 class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "DataContract.HeroNode [no = "+ no +", name = "+ name + ", nickName =" + nickName +"]";
    }
}

