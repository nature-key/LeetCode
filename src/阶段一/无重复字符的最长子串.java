package 阶段一;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {


    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int left=0;
        int max=0;
        for (int i = 0; i < length; i++) {
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }

        return max;


    }

}
