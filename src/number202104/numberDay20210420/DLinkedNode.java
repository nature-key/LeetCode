package number202104.numberDay20210420;

public class DLinkedNode {

    int key;

    int value;

    DLinkedNode pre;

    DLinkedNode next;

    public DLinkedNode() {
    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DLinkedNode getPre() {
        return pre;
    }

    public void setPre(DLinkedNode pre) {
        this.pre = pre;
    }

    public DLinkedNode getNext() {
        return next;
    }

    public void setNext(DLinkedNode next) {
        this.next = next;
    }
}
