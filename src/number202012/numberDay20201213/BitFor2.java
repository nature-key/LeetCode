package number202012.numberDay20201213;

import java.util.Arrays;
import java.util.Vector;

public class BitFor2 {

    /**
     * 判断是否是2的幂次方
     * @param n
     * @return
     */
    private static  boolean isBit(int n){
        return  n>0&&((n&(n-1))==0);
    }

    /**
     * 获取1的个数
     * @param num
     * @return
     */
    private static int[] numBit(int num){
        int[] v = new int[num+1];
        for (int i = 1; i <= num; i++) {
            int index=i&(i-1);
            v[i]+=v[index]+1;
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(isBit(2));
        System.out.println(Arrays.toString(numBit(2)));

    }


}
