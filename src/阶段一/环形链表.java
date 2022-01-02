package 阶段一;

import 基础数据结构.ListNode;
import 基础数据结构.ListNodeUtil;

public class 环形链表 {


    private static boolean isCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode.value == slowNode.value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle1(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode.value == slowNode.value) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        ListNodeUtil.addNode(3);
        ListNode listNode = ListNodeUtil.addNode(2);
        ListNodeUtil.addNode(0);
        ListNode tail = ListNodeUtil.addNode(-4);

        ListNodeUtil.print();


    }

}
