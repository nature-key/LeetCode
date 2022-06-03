package 阶段一;

import 基础数据结构.ListNode;

public class K个一组翻转链表 {



    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode  dump = new ListNode(-1);
        dump.next=head;

        ListNode curr=head;
        ListNode temp = null;
        ListNode pre=dump;

        int n=0;
        while (head!=null){
            head=head.next;
            n++;
        }

        for (int i = 0; i < n/k; i++) {
            for (int j = 1; j < k; j++) {
                temp=curr.next;
                curr.next=temp.next;
                temp.next=pre.next;
                pre.next=temp;
            }
            pre=curr;
            curr=pre.next;
        }

        return dump.next;
    }
}
