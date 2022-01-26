package 阶段一;

public class 位1的个数 {


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
