package number202102.numberDay20210227;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen(0, 0, n, "", result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


    private static void gen(int left, int right, int n, String s, List<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            gen(left + 1, right, n, s + "(", result);
        }

        if (left > right) {

            gen(left, right + 1, n, s + ")", result);
        }

    }


}
