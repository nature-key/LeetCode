package 阶段一;

import java.util.LinkedList;
import java.util.Queue;

public class 用队列实现栈 {

    private static  Queue<String> queue1=new LinkedList();
    private static  Queue<String> queue2=new LinkedList();

    /**
     * 1.先放入队列2
     * 2.如果队列1有值，然后把队列1的数值放入队列2，
     * 3.交换队列queue1=queue2;保留queue1为临时temp队列
     * 4.queue2=temep
     * @param value
     */
    public static void push(String value){
        queue2.offer(value);
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<String> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }

    public static String pop(){
        return queue1.poll();
    }

    public static String top(){
        return queue1.peek();
    }

    public static boolean isEmpty(){
        return queue1.isEmpty();
    }





}
