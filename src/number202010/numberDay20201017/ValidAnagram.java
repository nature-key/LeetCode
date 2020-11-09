package number202010.numberDay20201017;

import java.util.Arrays;

public class ValidAnagram {



    public static boolean isValidAnagram(String s ,String t){

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return  Arrays.equals(chars1,chars2);
    }

    public static boolean isValidAnagramHash(String s, String t){
        if (s.length()!=t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] a =new int[26];
        for (int i = 0; i < chars1.length; i++) {
            a[chars1[i]-'a']++;
            a[chars2[i]-'a']--;
        }


        for (int i = 0; i < a.length; i++) {
            if (a[i]!=0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a="cat";
        String b="tca";
        boolean validAnagram = isValidAnagram(a, b);
        boolean validAnagramHash = isValidAnagramHash(a, b);

        System.out.println(validAnagram);
        System.out.println(validAnagramHash);

    }

}
