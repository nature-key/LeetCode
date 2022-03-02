package 阶段一.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache2 extends LinkedHashMap<Integer,Integer> {

    private  int capaCity;

    public LruCache2(int capacity) {
        super(capacity,0.75F,true);
        this.capaCity=capacity;
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
        return size()>capaCity;
    }
}
