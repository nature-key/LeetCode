package 阶段热身.number202105.numberDay20210501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soution {


    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> res = new ArrayList<>();
        if (n < m) {
            return res;
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < m; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            sCount[s.charAt(i - m) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }


}
