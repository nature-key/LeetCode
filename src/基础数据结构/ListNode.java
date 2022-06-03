package 基础数据结构;

public class ListNode {

    public int value;

    public ListNode  next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int val, ListNode next) { this.value = val; this.next = next; }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
