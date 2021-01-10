package number202101.numberDay20210105;

public class DoubleLink extends AbstractDoubleLink {

    private Node head;

    private Node last;

    DoubleLink() {
        head = null;
        last = head;
    }

    @Override
    public void addFirst(Node node) {
        if (head == null) {
            last = node;
        } else {
            head.pre = node;
        }
        node.next = head;
        head = node;
    }

    @Override
    public void remove(Node node) {
        Node current = head;
        while (current != null && current.key != node.key) {
            current = current.next;
        }
        if (current == null) {
            //不处理
        } else {
            if (current == head) {
                head = current.next;
                current.next.pre = null;
            } else if (current == last) {
                last = current.pre;
                current.pre.next = null;
            } else {
                current.pre.next = current.next;
                current.next.pre = current.pre;
            }
        }
        System.out.println("删除节点 val=" + current.val+"key="+current.key);
    }

    @Override
    public Node removeLast(Node x) {
        Node current = last;
        if (head.next == null) {
            head = null;
        } else {
            last.pre.next = null;
        }
        last = last.pre;
        return current;
    }

    public Node removeLast() {
        Node current = last;
        if (head.next == null) {
            head = null;
        } else {
            last.pre.next = null;
        }
        last = last.pre;
        return current;
    }

    public Node removeFirst() {
        Node current = head;
        if (head.next == null) {
            head = null;
        } else {
            head.next.pre = null;
        }
        last = head.next;
        return current;


    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        LRUCache lruCache =new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
    }

}
