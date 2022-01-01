package 阶段热身.number202101.numberDay20210105;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    class LRUmap extends LinkedHashMap<Integer,Integer>{
        private int capacity;
        LRUmap(int capacity){
            super(capacity,0.75F,true);
            this.capacity=capacity;
        }

        @Override
        public Integer get(Object key) {
            return super.getOrDefault(key,-1);
        }

        //        public int get(int key){
//            return super.getOrDefault(key,-1);
//        }

        @Override
        public Integer put(Integer key, Integer value) {
            return super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size()>capacity;
        }
    }


}
