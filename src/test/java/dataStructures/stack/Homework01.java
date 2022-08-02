package dataStructures.stack;

import org.junit.jupiter.api.Test;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/26 10:57
 */
public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void test01(){
        IntStack stack = new IntStack(16);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(9);
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}
