package DataContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/7/27 15:34
 */
public class PolandNotation {

    public static void main(String[] args) {
        //先定义逆波兰表达式
        //（3+4）* 5 -6 => 3 4 + 5 * 6 -
        //说明为了方便，逆波兰表达式的数字和符号使用空格隔开
//        String suffixExpression ="3 4 + 5 * 6 -";
        String suffixExpression ="4 5 * 8 - 60 + 8 2 / +";
        String expression="1+((2+30)*4)-50";
        //思路
        //1.先将“3 4 + 5 * 6 -” =>放到ArrayList中
        //2.将ArrayList传递给一个方法，比那里ArrayList配合栈完成计算

        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList="+rpnList);
        System.out.println("list："+toInfixExpressionList(expression));
        List<String> suffixList=parseSuffixExpressionList(toInfixExpressionList(expression));
        System.out.println("suffixList"+suffixList);
        int res=calculate(suffixList);
        System.out.println("计算结果是："+res);
    }

    //将中缀表达式转换成对应的List
    //s="1+((2+3)*4)-5";
    public static List<String> toInfixExpressionList(String s){
        //定义一个List，存放中缀表达式 对应的内容
        List<String> ls=new ArrayList<>();
        int i=0;//这是一个指针，用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;//每遍历到一个字符，就放入到c
        do{
            //如果c是一个非数字，需要加入到ls
            if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
                ls.add(""+c);
                i++;//i需要后移
            }else{//如果是一个数，需要考虑多位数
                str="";//先将str置成""
                while(i<s.length() && (c=s.charAt(i))>=48 && (c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while(i<s.length());

        return ls;
    }

    /**
     * 将中缀表达式转换为 后缀表达式
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1= new Stack<>();//符号栈
        //说明：因为s2栈无pop出栈操作，而且需要逆序打印，所以为了方便实现，以ArrayList形式存储即可
        List<String> s2=new ArrayList<String>();

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入s2
            if(item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号“）”，则依次弹出s1栈顶的运算符，并压入s2，知道遇到左括号为止，此时将这对括号消除
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//!!!将（弹出s1栈，消除小括号
            }else{
                //若item(运算符)的优先级小于等于栈顶运算符的优先级，将s1栈顶的运算符弹出并加入到s2中，
                // 再次转到上述步骤中与s1中的新的栈顶比较
                //问题：缺少一个比较优先级高低的方法
                while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                //还需要将item压入栈中
                s1.push(item);
            }
        }
        //将s1剩余的运算符依次弹出并压入到s2
        while(s1.size()!=0){
            s2.add(s1.pop());
        }

        return s2;//注意因为是存放到List，因此按顺序输出就是对应的后缀表达式对应的List
    }

    public static String replaceAllBlank(String s){
        // \\s+ 匹配任何空包字符，包括空格、制表符、换页符等等 等价于 [\f\n\r\t\v]
        return s.replaceAll("\\s+","");
    }


    //讲一个逆波兰表达式和，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        //将suffixExpression分割
        String[] split =suffixExpression.split(" ");
        List<String>list=new ArrayList<String>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /**
     * 1）从左至右扫描，将3和4压入堆栈；
     * 2）遇到+运算符则弹出4和3
     * 3）将5入栈
     * 4）接下来是*运算符，因此弹出5和7，计算出7*5=35，将35入栈
     * 5）将6入栈
     * 6）最后是-运算符，计算出35-6的值，即29，由此得出最终结果
     */
    public static int calculate(List<String> ls) {
        //创建给栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        //遍历ls
        for (String item : ls) {
            if (item.matches("\\d+")) {//匹配的是多位 数
                //入栈
                stack.push(item);
            }else{
                //pop出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else{
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(""+res);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}

class Operation{
    private static int ADD =1;
    private static int SUB =1;
    private static int MUL =2;
    private static int DIV =2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation){
        int res=0;
        switch (operation){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return res;
    }
}
