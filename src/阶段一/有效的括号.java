package 阶段一;

import 基础数据结构.MyStack;

import java.util.HashMap;
import java.util.Map;

public class 有效的括号 {

    private static final Map map = new HashMap();

    private static final MyStack stack = new MyStack(100);

    static {
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String key = String.valueOf(aChar);
            if (!map.containsKey(key)) {
                stack.push(key);
            } else if (stack.isEmpty() || !stack.pop().equals(map.get(key))) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            String key = String.valueOf(aChar);
            if (!map.containsKey(key)) {
                stack.push(key);
            } else if (stack.isEmpty() || !stack.pop().equals(map.get(key))) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid1("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid1("([)]"));
    }
}
