package 阶段一.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    class  LinkedNode{
        int key;
        int value;
        LinkedNode next;
        LinkedNode pre;

        public LinkedNode() {
        }
        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,LinkedNode> map = new HashMap<>();

    private int size;

    private int capacity;

    LinkedNode head,tail;


    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.size=0;
        head=new LinkedNode();
        tail=new LinkedNode();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key){
        LinkedNode linkedNode = map.get(key);
        if(linkedNode==null){
            return -1;
        }
        moveToHead(linkedNode);
        return linkedNode.value;
    }


    public void  put(int key,int value){
        LinkedNode linkedNode = map.get(key);
        if(linkedNode==null){
            LinkedNode  linkedNode1=new LinkedNode(key,value);
            map.put(key,linkedNode1);
            addHead(linkedNode1);
            size++;
            if(size>capacity){
                LinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            linkedNode.value=value;
            moveToHead(linkedNode);
        }


    }



    private void addHead(LinkedNode node){
        node.next=head.next;
        node.pre=head;
        head.next.pre=node;
        head.next=node;
    }

    private void  moveToHead(LinkedNode node){
        removeNode(node);
        addHead(node);
    }

    private void removeNode(LinkedNode node){
        node.next.pre=node.pre;
        node.pre.next=node.next;
    }

    private LinkedNode removeTail(){
        LinkedNode pre = tail.pre;
        removeNode(pre);
        return pre;
    }

}
