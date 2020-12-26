package juc.test;


import java.util.regex.Pattern;

public class Test {


    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = new String("abc");
//        String str3 = str2.intern();
//        System.out.println(str1 == str2);//false
//        System.out.println(str2 == str3);//false
//        System.out.println(str1 == str3);//true

        String text="abbc";
        String reg="ab{1,3}+bc";

        boolean matches = Pattern.matches(reg, text);
        System.out.println(matches);



    }

}
