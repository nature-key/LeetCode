package 阶段热身.number202101.numberDay20210126;

import java.util.HashMap;
import java.util.Map;

public class ListNode {

    private Node root = new Node();

    private int size;


    private void add(int x) {
        Node newNode = new Node(x);
        if (root.getNext() == null) {
            root.setNext(newNode);
        }
        Node tempNode = root;
        while (tempNode.getNext() != null) {
            tempNode = tempNode.getNext();
        }
        tempNode.setNext(newNode);
        size++;
    }

    private Node get(int x) {
        Node temp = root;
        while (temp.getVal() != x) {
            temp = temp.getNext();
        }
        return temp;
    }


    private boolean hasCycle(Node head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    private boolean hasCycle2(Node head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp.getNext() != null) {
            Node next = temp.getNext();
            if (map.containsKey(next)) {
                return true;
            } else {
                map.put(next, next);
            }
            temp = next;
        }

        return false;
    }


}
