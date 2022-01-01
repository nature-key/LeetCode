package 阶段热身.number202010.numberDay20201006;

public class LinkNodeUtil {


    /**
     * 插入节点
     *
     * @param head
     * @param data
     */
    public static void addNode(LinkNode head, int data) {
        LinkNode insertNode = new LinkNode(data);
        LinkNode currentNode = head;
        while (currentNode.next != null) {
            LinkNode nextNode = currentNode.next;
            currentNode = nextNode;
        }
        currentNode.setNext(insertNode);
    }


    public static void addNodes(LinkNode head, int size) {
        for (int i = 1; i < size; i++) {
            addNode(head, i);
        }
    }

    public static void show(LinkNode node) {
        do {
            System.out.print(node.value+" ");
            node = node.next;
        } while (node != null);
        System.out.println();
    }


}
