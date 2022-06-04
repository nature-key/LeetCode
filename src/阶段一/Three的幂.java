package 阶段一;

public class Three的幂 {

    /**
     * 我们不断地将 n 除以 3，直到 n=1。
     * 如果此过程中 n 无法被 3 整除，就说明 n 不是 3 的幂
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {

        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
