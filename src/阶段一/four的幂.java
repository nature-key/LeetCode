package 阶段一;

public class four的幂 {

    boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }


}
