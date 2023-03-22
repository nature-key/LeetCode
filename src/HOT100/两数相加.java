package HOT100;

import 基础数据结构.ListNode;

public class 两数相加 {

    /**
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补
     * 0
     * 0，比如 987 + 23 = 987 + 023 = 1010
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carray = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.value : 0;
            int n2 = l2 != null ? l2.value : 0;
            int sum = n1 + n2 + carray;
            carray = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carray==1) {
            cur.next=new ListNode(carray);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);

        listNode7.setNext(listNode8);
        listNode8.setNext(listNode9);



        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode3.setNext(listNode2);


        ListNode listNode = addTwoNumbers(listNode7, listNode3);

        while (listNode != null) {
            System.out.println(listNode.value);
            listNode=listNode.next;
        }



    }

}
