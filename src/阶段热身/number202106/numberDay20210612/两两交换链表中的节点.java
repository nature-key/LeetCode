package 阶段热身.number202106.numberDay20210612;

import 阶段热身.common.ListNode;
import 阶段热身.common.ListNodeUtil;

public class 两两交换链表中的节点 {

    public static ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode a = p;
        ListNode b = p;
        ListNode tmp = p;
        while (b != null && b.next != null && b.next.next != null) {
            a = a.next;
            b = b.next.next;
            tmp.next = b;
            a.next = b.next;
            b.next = a;
            tmp = a;
            b = a;
        }
        return p.next;
    }

    public ListNode swapPairs1(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode a = p;
        ListNode b = p;
        ListNode temp = p;
        while (p != null && p.next != null && p.next.next != null) {
            a = a.next;
            b = b.next.next;
            temp.next = b;
            a.next = b.next;
            b.next = a;
            temp = a;
            b = a;
        }
        return p.next;
    }

    public static void main(String[] args) {
        ListNodeUtil list = new ListNodeUtil();
        int[] nodes = {1, 2, 3, 4};
        for (int node : nodes) {
            list.add(node);
        }
        ListNode listNode = swapPairs(list.getHead());
        ListNodeUtil nodeUtil = new ListNodeUtil(listNode);
        nodeUtil.print();
    }
}
