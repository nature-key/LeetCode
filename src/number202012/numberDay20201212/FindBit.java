package number202012.numberDay20201212;

public class FindBit {


    private static int find1(int n) {
        int mask = 1;
        int res = 1;
        for (int i = 0; i < 32; i++) {

            if ((n & mask) == 1) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }
    private static  int  find2(int n){

        int res=0;
        while (n!=0){
            ++res;
            n=n&(n-1);
        }
        return res;
    }

    /**
     * n&(n-1) 清除最后一位1  1010-->1000
     * n&1 判断偶数奇数
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(find1(2));
        System.out.println(find2(2));
    }

}
