package number202104.numberDay20210420;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {

    private Map<Integer,DLinkedNode> cache=new HashMap<>();

    DlinkedNodeList cacheNode;

    public LRUCache1( int capacity) {
        cacheNode=new DlinkedNodeList(capacity);
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }
        cacheNode.removeNode(node);
        cacheNode.addFirst(node);
        return node.value;
    }

    public void  put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node==null){
            DLinkedNode linkedNode = new DLinkedNode(key,value);
            cache.put(key,linkedNode);
            cacheNode.addFirst(linkedNode);
            if(cacheNode.size()>cacheNode.capacity){
                DLinkedNode removeLast = cacheNode.removeLast();
                cache.remove(removeLast.key);
            }
        }else{
            cacheNode.removeNode(node);
            node.setValue(value);
            cacheNode.addFirst(node);
        }
    }

    public static void main(String[] args) {
        LRUCache1 lRUCache = new LRUCache1(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));


    }

}
