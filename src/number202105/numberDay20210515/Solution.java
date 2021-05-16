package number202105.numberDay20210515;

public class Solution {

    private int start, maxLen;

    public String longestPalindromw(String s) {
        int length = s.length();

        if (length < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindRome(s, i, i);//偶数
            extendPalindRome(s, i, i + 1);//奇数
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindRome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }

        if (maxLen < k - j - 1) {
            start = j + 1;
            maxLen = k - j - 1;
        }
    }


    public int logestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;

        for (int i : count) {
            ans += i / 2 * 2;
            if (i % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromw("babad"));
    }

}
