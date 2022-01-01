package 阶段热身.number202010.numberDay20201008;

import java.util.HashMap;
import java.util.Map;

public class StringMatch {


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     * @return
     */
    private static boolean isValid(String s) {
        int length;
        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "")
                    .replace("[]", "");
        } while (length != s.length());
        return s.length() == 0;
    }

    private static boolean isValidTwo(String s) {
        ListStack<Character> stack = new ListStack<>();
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                stack.push(aChar);
            } else if (!stack.isEmpty()) {
                Character pop = stack.pop();
                Character character = map.get(aChar);
                if (!pop.equals(character)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()[]{}";

        System.out.println(isValid(s));
        System.out.println(isValidTwo(s));


    }


}
