package 阶段热身.number202102.numberDay20210221;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public List<String> letter(String digits){

        if (digits==null||digits.length()==0) {
            return  new ArrayList<>();
        }

        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> resutl =new ArrayList<>();

        search("",digits,0,resutl,map);
        return resutl;
    }

    public void search(String s,String digits,int i,List<String> result,Map<Character,String> map){

        if (i==digits.length()) {
            result.add(s);
            return;
        }
        String lettle = map.get(digits.charAt(i));
        for (int j = 0; j < lettle.length(); j++) {
            search(s+lettle.charAt(j),digits,i+1,result,map);
        }
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.letter("23"));
    }


}
