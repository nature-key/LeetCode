package 华为;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class 明明的随机数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        TreeSet treeSet = new TreeSet();
        for (int i = 0; i < num; i++) {
            treeSet.add(sc.nextInt());
        }

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
