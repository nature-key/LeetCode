package number202105;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

    public String longestCommonPreFix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {

            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    private char[] resversString(char[] s) {
        if (s == null) {
            return null;
        }

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        return s;

    }


    public String resvereWords(String s) {
        String[] split = s.trim().split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join(" ", split);
    }

}
