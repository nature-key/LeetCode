package number202010.numberDay20201026;

public class PowByN {


    private static double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        double y = myPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    private static double myPow1(double x, int n) {
        if (x == 0.0) {
            return 0;
        }
        long d = n;
        double res = 1.0;
        if (d < 0) {
            d = -d;
            x = 1 / x;
        }
        while (d > 0) {
            if (d % 2 == 1) {
                res *= x;
            }
            x *= x;
            d/=2;
        }

        return res;


    }

    public static void main(String[] args) {

        double x = 2;
        long n = 10;

        System.out.println(myPow(x, 10));
        System.out.println(myPow1(x, 10));

    }


}
