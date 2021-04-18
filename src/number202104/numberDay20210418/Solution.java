package number202104.numberDay20210418;

public class Solution {

    /**
     * n&(n-1) 清除最低的1
     * n&-n 获取最低的1
     * @param n
     * @return
     */

    private static int hw(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    private static boolean isPower(int n){
        return n!=0&&(n&(n-1))==0;
    }

    public static void main(String[] args) {

    }
}
