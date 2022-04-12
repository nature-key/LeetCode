package 阶段一;

import java.util.Arrays;

    public class 比特位计数 {

    /**
     * 对于一个2的幂次方的数i，i与i-1的逻辑与(&)结果为0，即res[i & i-1] = res[0];，
     * 而i的二进制中1的个数只有一个, 因此
     *     res[i] = res[i&i-1]+1;
     * 奇数点分析：
     * 对于一个奇数k，k的二进制比k-1的二进制总是多一个1，而 k&k-1 = k-1 也总是成立，
     * 因此
     *     res[k] = res[k-1]+1=res[k&k-1]+1;
     *
     * https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     * @param n
     * @return
     */
    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }


    public static int[] countBits1(int n){
        int[] bits=new int[n+1];
        for (int i = 0; i <= n; i++) {
            bits[i]=count(i);
        }
        return bits;
    }


    private static int count(int n){
        int count=0;
        while (n!=0){
             n = n & (n - 1);
             count++;
        }
       return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
        System.out.println(Arrays.toString(countBits1(2)));
    }


}
