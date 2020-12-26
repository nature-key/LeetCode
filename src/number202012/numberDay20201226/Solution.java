package number202012.numberDay20201226;

public class Solution {


    /**
     * 最多买一只股票
     *
     * @param prices -
     * @return -
     */
    private static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        int res = 0;
        int[][] profit = new int[length][3];
        profit[0][0] = 0;//不动
        profit[0][1] = -prices[0];//买入
        profit[0][2] = 0;//卖出
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = profit[i - 1][0];
            profit[i][1] = Math.max(profit[i - 1][1], profit[i - 1][0] - prices[i]);
            profit[i][2] = profit[i - 1][1] + prices[i];
            res = Math.max(Math.max(Math.max(res, profit[i][0]), profit[i][1]), profit[i][2]);
        }
        return res;
    }

    private static  int maxProfit1(int [] prices){
        int length = prices.length;
        if (length==0) {
            return 0;
        }
        int[][] profit=new int[length][2];

        profit[0][0]=0;//不持股
        profit[0][1]=-prices[0];//持股

        for (int i = 1; i < prices.length; i++) {
            profit[i][0]=Math.max(profit[i-1][0],profit[i-1][1]+prices[i]);
            profit[i][1]=Math.max(profit[i-1][1],-prices[i]);
        }
        return profit[length-1][0];

    }

    public static void main(String[] args) {
        int [] res= {7,1,5,3,6,4};
        System.out.println(maxProfit(res));
        System.out.println(maxProfit1(res));
    }

}
