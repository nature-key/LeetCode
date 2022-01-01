package 阶段热身.number202106.numberDay20210612;

import 阶段热身.common.ListNode;
import 阶段热身.common.ListNodeUtil;

public class 反转链表206 {


    public static ListNode reverseList(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    private static  ListNode  reverseList1(ListNode head){
        ListNode cur= head;
        ListNode pre= null;

        while (cur!=null){
            ListNode temp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNodeUtil list = new ListNodeUtil();
        int[] nodes = {1, 2, 3, 4, 5};
        for (int node : nodes) {
            list.add(node);
        }
        list.print();
        ListNode listNode = reverseList(list.getHead());
        ListNodeUtil list1 = new ListNodeUtil(listNode);
        list1.print();
    }
}
