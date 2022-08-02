package LeetCode.practice;

/**
 * @author : 杨帅
 * @description: 2. 两数相加
 * @date： 2021/10/29 14:26
 */
public class Homework08 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = addTwoNumbers(listNode1, listNode4);
        System.out.println(listNode);
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Stack<ListNode> stack1 = new Stack<>();
//        Stack<ListNode> stack2 = new Stack<>();
//        ListNode l1Next = l1.next;
//        ListNode l2Next = l2.next;
//        stack1.push(l1);
//        stack2.push(l2);
//        while(l1Next!=null){
//            stack1.push(l1Next);
//            l1Next = l1Next.next;
//        }
//        while(l2Next!=null){
//            stack2.push(l2Next);
//            l2Next = l2Next.next;
//        }
//        String[] calculate = calculate(stack1, stack2);
//        List<ListNode> list = new ArrayList<>();
//        for (String i : calculate) {
//            ListNode listNode = new ListNode(Integer.parseInt(i));
//            list.add(listNode);
//        }
//        for (int i = 0; i < list.size()-1; i++) {
//            list.get(i).next = list.get(i+1);
//        }
//        return list.get(0);
//
//    }

    //    public static String[] calculate(Stack<ListNode> stack1,Stack<ListNode> stack2){
//        int len1 = stack1.size();
//        int len2 = stack2.size();
//        BigDecimal res1 = new BigDecimal(0);
//        BigDecimal res2 = new BigDecimal(0);
//        for (int i = 0; i < len1; i++) {
//            res1 =res1.add(new BigDecimal(stack1.pop().val * Math.pow(10,len1-i-1)));
//        }
//        for (int i = 0; i < len2; i++) {
//            res2 =res2.add(new BigDecimal(stack2.pop().val * Math.pow(10,len2-i-1)));
//        }
//        char[] chars = res1.add(res2).toString().toCharArray();
//        String[] res = new String[chars.length];
//        for (int i = 0; i <res.length ; i++) {
//            res[i] = String.valueOf(chars[res.length-i-1]);
//        }
//        return res;
//    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {    
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
