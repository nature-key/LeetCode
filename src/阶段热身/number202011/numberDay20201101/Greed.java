package 阶段热身.number202011.numberDay20201101;

public class Greed {


    private  static  int  maxValue(int[] price){
        int count=0;
        for (int i = 1; i < price.length; i++) {
            int temp =price[i]-price[i-1];
            if (temp>0) {
                count+=temp;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] price={7,1,5,3,6,4};
        int[] price1={1,2,3,4,5};
        System.out.println(maxValue(price1));

    }


}
