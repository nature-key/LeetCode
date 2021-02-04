package number202102.numberDay20210204;

import java.util.*;

public class Soution {

 private static  List<List<String>> getAnagrams(String [] strs){

     Map<String,List<String>> map =new HashMap<>();

     for (String str : strs) {
         char[] chars = str.toCharArray();
         Arrays.sort(chars);

         String s = String.valueOf(chars);
         List<String> list = map.getOrDefault(s, new ArrayList<>());
         list.add(str);
         map.put(s,list);
     }

     return new ArrayList<>(map.values());

 }

 private static  List<List<String>> getisANAGRAM(String[] strs){
     Map<String,List<String>> map =new HashMap<>();

     for (String str : strs) {
         int[] count =new int[26];

         char[] chars = str.toCharArray();
         for (int i = 0; i < chars.length; i++) {
             count[chars[i]-'a']++;
         }
         StringBuffer sb =new StringBuffer();
         for (int i = 0; i < 26; i++) {
             if (count[i]!=0) {
                 sb.append(i+'a');
                 sb.append(count[i]);
             }
         }
         String s = sb.toString();

         List<String> list = map.getOrDefault(s, new ArrayList<>());
         list.add(str);
         map.put(s,list);

     }

     return new ArrayList<>(map.values());

 }

    public static void main(String[] args) {

     String [] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(getAnagrams(strings));
        System.out.println(getisANAGRAM(strings));

    }





}
