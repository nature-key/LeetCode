package 阶段一;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {

    /**
     * https://leetcode.cn/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

//        Arrays.stream(intervals).sorted((v1,v2)->v1[0]-v2[0]);
        Arrays.sort(intervals,((v1,v2)->v1[0]-v2[0]));
        List<int[]> res =new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L= intervals[i][0];
            int R= intervals[i][1];
            if(res.size()==0||res.get(res.size()-1)[1]<L){
                res.add(new int[]{L,R});
            }else {
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],R);
            }
        }

        return res.toArray(new int[res.size()][]);
    }

}
