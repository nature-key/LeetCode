package 阶段一;

import java.util.PriorityQueue;

public class 数据流中的第K大元素 {
    private PriorityQueue<Integer> queue;

    private int k;

    public 数据流中的第K大元素(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue(k);
        for (int num : nums) {
            add(num);
        }
    }


    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        int[] nums ={4,5, 8, 2};
        数据流中的第K大元素 larget=new 数据流中的第K大元素(3,nums);
        System.out.println(larget.queue.peek());
    }

}
