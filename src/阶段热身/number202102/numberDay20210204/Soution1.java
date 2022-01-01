package 阶段热身.number202102.numberDay20210204;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Soution1 {




    private static  int[] getSum2(int[] a,int target){

        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < a.length; i++) {
             int b=target- a[i];
            if (map.containsKey(b)) {
                return new int[]{i,map.get(b)};
            }
            map.put(a[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a={2,7,11,15};
        int target=9;

        System.out.println(Arrays.toString(getSum2(a, target)));
    }
}
