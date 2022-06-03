package 阶段一;

import 基础数据结构.ListNode;

public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dump = new ListNode(0,head);

        ListNode cur=dump;

        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.value==cur.next.next.value){
                int x=cur.next.value;
                while (cur.next!=null&&cur.next.value==x){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }

        }
        return dump.next;
    }
}
