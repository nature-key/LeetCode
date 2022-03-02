package 阶段一.LRU;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;

    private DubboCache cache;

    private int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        cache = new DubboCache();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).value;
        put(key, value);
        return value;
    }

    public void put(int key, int value) {
        Node x = new Node(key,value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key,x);
        }else {
            if(cache.size()==cap){
                cache.removeLast();
                map.remove(key);
            }
            cache.addFirst(x);
            map.put(key,x);
        }
    }


}
