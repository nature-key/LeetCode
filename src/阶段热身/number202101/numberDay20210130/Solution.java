package 阶段热身.number202101.numberDay20210130;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {


    private static  boolean isTrue(String str){
        char[] chars = str.toCharArray();
        Map<Character,Character> map = new HashMap();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        LinkedList stack =new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (map.containsKey(aChar)) {
                stack.addLast(aChar);
            }else if(stack.peekLast()!=null&&map.get(stack.pollLast())!=aChar){
                return false;
            }
        }
        return stack.size()==0;

    }

    public static void main(String[] args) {
        String str="([])";
        boolean aTrue = isTrue(str);

        System.out.println(aTrue);
    }
}
