package 阶段热身.number202102.numberDay20210204;

import java.util.Arrays;

public class Soution2 {

    private static boolean isAnagram(String t, String s) {
        if (t.length() <= 0 || s.length() <= 0) {
            return false;
        }
        char[] chars = t.toCharArray();
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars,chars1);
    }

    private static boolean isAnagram1(String t, String s) {
        if (t.length() <= 0 || s.length() <= 0) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < t.length(); i++) {
            count[s.charAt(i) -'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="car";
        String t="acr";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram1(s, t));
    }
}
