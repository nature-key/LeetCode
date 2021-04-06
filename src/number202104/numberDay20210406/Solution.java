package number202104.numberDay20210406;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> wordSet= new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> vistied=new HashSet<String>();
        int len=1;
        while (!beginSet.isEmpty()&&!endSet.isEmpty()){

            //交换 小的集合
            if(beginSet.size()>endSet.size()){
                Set<String> tempset=beginSet;
                beginSet=endSet;
                endSet=tempset;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i <chars.length ; i++) {
                    for (char c = 'a'; c <'z' ; c++) {
                       char old= chars[i];
                       chars[i]=c;
                        String target = String.valueOf(chars);
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        if(!vistied.contains(target)&&wordList.contains(target)){
                            temp.add(target);
                            vistied.add(target);
                        }
                        chars[i]=old;
                    }
                }
            }
            beginSet=temp;
            len++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord="hit";
        String endWord="cog";
        List<String> wordList= List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));


    }

}
