package number202012.numberDay20201220;

public class Palouqi {


    private static int solve(int n) {

        if (n <= 2) {
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n-1];
    }

    public static void main(String[] args) {
        System.out.println(solve(3));
    }

}
