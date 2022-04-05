package 华为;

import java.util.Scanner;

public class Number01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] split = line.split(" ");

        int length = split[split.length - 1].length();
        System.out.println(length);
    }
}
