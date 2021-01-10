package number202101.numberDay20210105;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> map;

    private DoubleLink cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleLink();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            int val = node.val;
            put(key, val);
            return val;
        }
    }


    public void put(int key, int val) {
        Node node = new Node(key, val);

        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        } else {
            if (cache.size() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            map.put(key, node);
            cache.addFirst(node);
        }


    }

}
