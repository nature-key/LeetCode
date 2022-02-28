package test;

import 基础数据结构.ListNodeUtil;

public class TestUtil {


    public static void main(String[] args) {
        int [] values={1,2,3,4,5};
        ListNodeUtil.addNodes(values);
        ListNodeUtil.print();
        testCPULoop();
    }

    public static void testCPULoop()  {
        System.out.println("请求cpu死循环");
        Thread.currentThread().setName("loop-thread-cpu");
        int num = 0;
        while (true) {
            num++;
            if (num == Integer.MAX_VALUE) {
                System.out.println("reset");
            }
            num = 0;
        }

    }
}
