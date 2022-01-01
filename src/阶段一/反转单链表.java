package 阶段一;

import 基础数据结构.ListNode;
import 基础数据结构.ListNodeUtil;

public class 反转单链表 {


    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static  ListNode reverseList1(ListNode head){
        if (head==null) {
            return null;
        }
        ListNode prev=null;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.getNext();
            curr.setNext(prev);
            prev=curr;
            curr=next;
        }
        return prev;
    }

    private static  ListNode reverseList2(ListNode head){

        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next = curr.getNext();
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        return prev;
    }




    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        ListNodeUtil.addNodes(values);
        ListNode head = reverseList2(ListNodeUtil.getHead());
        ListNodeUtil.setHead(head);
        ListNodeUtil.print();


    }


}
