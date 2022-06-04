package 阶段一;

public class 颠倒二进制位 {

    /**
     * 创建res存放反转后的数
     * 由于int是32位的,所以我们遍历n的每一位
     * 获取n&1的值,然后左移(32-i)位,就变成了最高位
     * 在进行res|=p,就把n的第i位放在了res的(32-i)位,n每次右移1位
     * 位运算&,如果两个相应位都为1,则该位的结果为1,否则为0
     * 位运算|,只要对应的二个二进位有一个为1时，结果位就为1
     */
    public int reverseBits(int n) {
        int res=0;
        for (int i = 1; i <= 32&&n!=0; i++) {
            int p = n & 1;
            p <<= (32-i);
            res|=p;
            n=n>>>1;
        }
        return res;
    }
}
