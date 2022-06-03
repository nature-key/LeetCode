package 阶段一;

import 基础数据结构.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> visist = new HashSet<>();

        ListNode temp = headA;
        while (temp != null) {
            visist.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visist.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
