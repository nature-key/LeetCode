package 阶段一;

public class 数字转换为十六进制数 {

    public String toHex(int _num) {

        if (_num==0) {
            return "0";
        }
       long num=_num;
        StringBuffer sb = new StringBuffer();
        if(num<0){
            num=(long)(Math.pow(2,32)+num);
        }
        while (num!=0){
            long u = num%16;
            char c=(char)(u+'0');
            if (u>=10) {
                c=(char) (u-10+'a');
            }
            sb.append(c);
            num/=16;
        }
        return sb.reverse().toString();
    }

}
