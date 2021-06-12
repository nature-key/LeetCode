package common;

public class ListNodeUtil {

    private ListNode head = null;

    public ListNodeUtil() {
    }

    public ListNodeUtil(ListNode head) {
        this.head = head;
    }

    public ListNode add(int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
        return head;
    }



    public void print() {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    public ListNode getHead() {
        return head;
    }
}
