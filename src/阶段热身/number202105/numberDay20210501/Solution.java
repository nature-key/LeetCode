package 阶段热身.number202105.numberDay20210501;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fisrtUniqChar(String str) {

        Map<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (hm.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
