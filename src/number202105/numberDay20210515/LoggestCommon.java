package number202105.numberDay20210515;

public class LoggestCommon {


    private int  logestCommonSub(String word1,String word2){
        int rowLenght=word1.length();
        int colLenght = word2.length();

        int [][] dp = new int[rowLenght+1][colLenght+1];

        for (int i = 0; i < rowLenght + 1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < colLenght + 1; i++) {
            dp[0][i]=0;
        }

        for (int row = 1; row < rowLenght + 1; row++) {

            for (int col = 1; col < colLenght + 1; col++) {
                char c = word1.charAt(row - 1);
                char c1 = word2.charAt(col - 1);
                if(c==c1){
                    dp[row][col]=dp[row-1][col-1]+1;
                }else{
                    dp[row][col]=Math.max(dp[row-1][col],dp[row][col-1]);
                }

            }
        }



        return dp[rowLenght][colLenght];

    }


    public static void main(String[] args) {
        LoggestCommon loggestCommon = new LoggestCommon();

        System.out.println(loggestCommon.logestCommonSub("abc", "def"));

    }
}
