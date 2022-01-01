package 阶段热身.juc.test;


import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = new String("abc");
//        String str3 = str2.intern();
//        System.out.println(str1 == str2);//false
//        System.out.println(str2 == str3);//false
//        System.out.println(str1 == str3);//true

//        String text="abbc";
//        String reg="ab{1,3}+bc";
//
//        boolean matches = Pattern.matches(reg, text);
//        System.out.println(matches);

        Object[] objects = Stream.of(1, 45, 89, 34, 9, 78, 92, 12, 43)
                .filter(it -> it > 40)
                .sorted()
                .toArray();
        int i=0;
        while (true){

            System.out.println(i++);
        }

    }

}
