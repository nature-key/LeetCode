package 阶段一.LRU;

public class DubboCache {

    private Node tail;

    private Node head;

    private int size;

    public void remove(Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (tail == node) {
            node.pre.next = null;
            tail = node.pre;
        } else if (head == node) {
            node.next.pre = null;
            head = node.next;
        } else {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        size--;
    }

    public void addFirst(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            Node n = head;
            n.pre = node;
            node.next = n;
            head = node;
        }
        size++;
    }

    public Node removeLast() {
        Node node = this.tail;
        remove(node);
        return node;
    }

    public int size() {
        return size;
    }


}
