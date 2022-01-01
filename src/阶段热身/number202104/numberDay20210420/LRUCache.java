package 阶段热身.number202104.numberDay20210420;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity=capacity;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key,-1);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}
