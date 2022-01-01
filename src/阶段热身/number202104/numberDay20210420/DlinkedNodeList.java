package 阶段热身.number202104.numberDay20210420;

public class DlinkedNodeList {

    DLinkedNode tail;

    DLinkedNode head;

    int size;

    int capacity;

    public DlinkedNodeList(int capacity) {
        tail = new DLinkedNode();
        head = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
        this.size = 0;
        this.capacity=capacity;
    }

    public void addFirst(DLinkedNode node) {
        node.pre = head;
        node.next = tail;
        head.next.pre = node;
        head.next = node;
        size++;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public DLinkedNode removeLast() {
        if (tail.pre == head) {
            return null;
        }
        DLinkedNode node = tail.pre;
        removeNode(node);
        size--;
        return node;
    }

    public int size() {
        return size;
    }
}
