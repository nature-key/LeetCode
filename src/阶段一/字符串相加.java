package 阶段一;

public class 字符串相加 {

    public String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i=num1.length();
        int j= num2.length();
        int carry=0;
        while (i>=0||j>=0){
            int a=i>=0?num1.charAt(i)-'0':0;
            int b=j>=0?num1.charAt(j)-'0':0;
            int temp =a+b+carry;
            carry=temp/10;
            sb.append(temp%10);
            i--;
            j--;
        }
        if(carry==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
