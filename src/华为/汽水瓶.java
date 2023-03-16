package 华为;

public class 汽水瓶 {

    /**
     * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
     * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
     * 数据范围：输入的正整数满足
     */

    public static void main(String[] args) {

        int [] nums={3,10,81};
        for (int num : nums) {
            cal(num,0);
        }
    }


    public static void cal(int num,int count){
        int chushu=num/3;
        int yushu =num%3;

        count=count+chushu ;
        num=chushu+yushu;
        //如果除数加余数==1，则结束，因为借瓶子也不能换了
        if(num==1){
            System.out.println(count);
            return;
        }
        //如果num=2,3,则可以借瓶子或者不借，
        if(num==2||num==3){
            count++;
            System.out.println(count);
        }else{
            //否则继续递归
            cal(num,count);
        }








    }



}
