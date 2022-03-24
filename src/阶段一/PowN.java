package 阶段一;

public class PowN {


    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return (x == 1 || x == -1) ? 1 : 0;
        } else if (n == 0) {
            return 1;
        }
        //如果是负数，则使用倒数和-n
        if (n < 0) {
            return myPow(1 / x, -n);
        }
        //偶数  2^4=(2*2)^2
        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
            //奇数 2^5=(2^4)*2
        }
        return myPow(x, n - 1) * x;
    }

    public double myPow1(double x, int n) {
        if (x == 0.0) {
            return 0.0d;
        }
        double result = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            //这里相当于奇数，res*x
            if ((b & 1) == 1) {
                result *= x;
            }
            //这里就是偶数 x*x
            x *= x;
            //相当于n/2
            b >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        PowN powN = new PowN();
        System.out.println(powN.myPow(2, 5));

        System.out.println(powN.myPOW1(2,5));
    }


    public double pow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double sub = pow1(x, n / 2);
        return n % 2 == 0 ? sub * sub : sub * sub * x;
    }

    public double myPOW1(double x ,int n){
         if(n<0){
             x=1/x;
             n=-n;
         }
        return pow1(x,n);

    }






}
