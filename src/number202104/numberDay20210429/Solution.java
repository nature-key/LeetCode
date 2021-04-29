package number202104.numberDay20210429;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAngram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS, charsT);
    }

    public boolean isAngram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            table.put(c, table.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            table.put(c, table.getOrDefault(c, 0) - 1);
            if (table.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
