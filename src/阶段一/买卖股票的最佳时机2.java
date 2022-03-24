package 阶段一;

public class 买卖股票的最佳时机2 {

    /**
     * 贪心算法
     * @param prices -
     * @return
     */
    public static  int maxProfit(int[] prices) {
        int length = prices.length;
         if(length<2){
             return 0;
         }
        int res=0;
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            if(diff>0){
                 res +=diff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
            int [] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }


    public   int maxProfit1(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                result+=prices[i]-prices[i-1];
            }
        }
        return result;
    }


}
