package number202105.numberDay20210522;

public class Solution {

    private boolean dfs(String s, String p) {

        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean isFirstStr = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        boolean isMatchAny = p.length() > 1 && (p.charAt(1) == '*');//p第二位是否是*
        if (isMatchAny) {
            return dfs(s, p.substring(2)) || isFirstStr && (dfs(s.substring(1), p));
        }
        return isFirstStr && dfs(s.substring(1), p.substring(1));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dfs("mississippi", "mis*is*p*."));
        System.out.println(solution.dfs("aab", "c*a*b"));

    }
}
