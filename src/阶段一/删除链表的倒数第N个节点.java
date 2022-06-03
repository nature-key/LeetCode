package 阶段一;

import sun.jvm.hotspot.opto.HaltNode;
import 基础数据结构.ListNode;

public class 删除链表的倒数第N个节点 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next=head;
        ListNode start=pre;
        ListNode end=pre;

        while (n>0){
            start=start.next;
            n--;
        }

        while (start.next!=null){
            start=start.next;
            end=end.next;
        }

        end.next=end.next.next;
        return pre.next;



    }

}
