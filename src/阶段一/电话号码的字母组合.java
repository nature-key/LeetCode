package 阶段一;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {


    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List list = new ArrayList();
        dfs("", 0, phoneMap, list, digits);
        return list;
    }


    public void dfs(String s, int level, Map<Character, String> map,
                    List<String> list, String digest) {
        if (level == digest.length()) {
            list.add(s);
            return;
        }
        String str = map.get(digest.charAt(level));

        for (int i = 0; i < str.length(); i++) {
            dfs(s + str.charAt(i), level + 1, map, list, digest);
        }

    }


}
