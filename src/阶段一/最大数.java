package 阶段一;

import java.util.Arrays;

public class 最大数 {

    public String largestNumber(int[] nums) {

        int length = nums.length;
        String[] str=new String[length];
        for (int i = 0; i < length; i++) {
            str[i]=nums[i]+"";
        }

        Arrays.sort(str,(a,b)->{
            String ab=a+b;
            String sb=b+a;
            return ab.compareTo(sb);
        });

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            sb.append(str[i]);
        }
        int n = sb.length();
        int k=0;
        while (k<n-1&&sb.charAt(k)=='0') k++;

        return sb.substring(k);


    }
}
