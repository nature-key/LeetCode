package 阶段一;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(0, 0, n, "", ans);
        return ans;
    }


    private static void gen(int left, int right, int n, String result, List<String> ans) {
        if (left == n && right == n) {
            ans.add(result);
            return;
        }
        if (left < n) {
            gen(left + 1, right, n, result + "(", ans);
        }
        if (right < n && left > right) {
            gen(left, right + 1, n, result + ")", ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
