package 阶段一;

import java.util.Arrays;

public class 分饼干 {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int childCount=0;
        int cookieCount=0;
        //饼干 和孩子进行排序，然后那饼干和孩子的胃口比较，大于等于则孩子数量加一，否则去下一个饼干
        while (childCount<g.length&&cookieCount<s.length){
            if(g[childCount]<=s[cookieCount]){
                childCount++;
            }
            cookieCount++;
        }
        return childCount;
    }
}
