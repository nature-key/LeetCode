package number202010.numberDay20201006;


import java.util.HashSet;

public class LinkNodeTest {

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    private static LinkNode reverseList(LinkNode head) {
        LinkNode cur = head;
        LinkNode prev = null;
        while (cur != null) {
            LinkNode tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
        }
        return prev;
    }

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    private static LinkNode swapLinkNode(LinkNode head) {
        //1.终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //2.记录头结点为临时节点
        LinkNode temp = head.next;
        //3.不管怎样，此时的头结点下一个节点是你临时节点下一个节点交换后的节点
        head.next = swapLinkNode(temp.next);
        //4.交换临时节点的下一个节点就是你的此时的头节点
        temp.next = head;
        //5.此时的临时节点就是头节点返回就可以了
        return temp;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     */
    private static boolean hasCycleOne(LinkNode head) {
        HashSet set = new HashSet();
        LinkNode temp = head;
        boolean flag = false;
        while (temp != null) {
            int tempSize = set.size();
            set.add(temp.value);
            if (tempSize == set.size()) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    /**
     * 块慢指针
     * @param head
     * @return
     */
    private static boolean hasCycleTwo(LinkNode head) {
        if (head == null) {
            return false;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow== fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(3);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(0);
        LinkNode node4 = new LinkNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
//        LinkNodeUtil.show(node1);


        System.out.println(hasCycleOne(node1));
        System.out.println(hasCycleTwo(node1));


//        LinkNode head = new LinkNode();
//        LinkNodeUtil.addNodes(head, 5);
//        LinkNodeUtil.show(head);
////        System.out.println("========");
////        LinkNodeUtil.show(reverseList(head));
//
//        LinkNode swapHead = swapLinkNode(head);
//        LinkNodeUtil.show(swapHead);
    }
}
