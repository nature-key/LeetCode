package 阶段一;

import 基础数据结构.ListNode;
import 基础数据结构.ListNodeUtil;

public class 两两交换链表中的节点 {

    public static ListNode swapPairs(ListNode head){
        ListNode dump = new ListNode(-1);
        dump.next=head;
        for (ListNode p=dump;p.next!=null&&p.next.next!=null;){
            ListNode a=p.next;
            ListNode b=p.next.next;
            p.next=b;
            a.next=b.next;
            b.next=a;
            p=a;
        }
        return dump.next;
    }


    private static  ListNode  swapPairs1(ListNode head){
        ListNode dump=new ListNode(-1);
        dump.next=head;
        for (ListNode p = dump;dump.next!=null&&dump.next.next!=null;){
            ListNode a=dump.next;
            ListNode b=dump.next.next;
            p.next=b;
            a.next=b.next;
            b.next=a;
            p=a;
        }
        return dump.next;
    }


    private static  ListNode swap(ListNode head){
        ListNode dump = new ListNode(-1);
        dump.next=head;

        for (ListNode p= dump;p.next!=null&&p.next.next!=null;){
            ListNode a= p.next;
            ListNode b =p.next.next;
            p.next=b;
            a.next=b.next;
            b.next=a;
            p=a;
        }

        return dump.next;

    }

    /**
     * test
     *
     * @param args
     */

    public static void main(String[] args) {
        int [] values={1,2,3,4,5};
        ListNodeUtil.addNodes(values);
        ListNode head = ListNodeUtil.getHead();
        ListNode listNode = swap(head);
        ListNodeUtil.setHead(listNode);
        ListNodeUtil.print();
    }


}
