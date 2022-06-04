package 阶段一;

public class 位1的个数 {

    /**
     * 判断奇数偶数
     *  x%2=1-->x&1==1
     *  x%2=0-->x&1==0
     * x>>1-->x/2
     * 清零最低位 x&(x-1)
     * x&-x得到最低位的1
     * x&~x==>0
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    public int hammingWeight1(int n){
        int count=0;
        for (int i = 0; i < 32; i++) {
            count+=n&1;
            n>>=1;
        }
        return count;
    }
}
