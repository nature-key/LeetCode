package 阶段一;

public class Sqrt {


    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public static int sqrt1(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(sqrt1(8));
    }




}
